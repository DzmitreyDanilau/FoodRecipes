package by.dzmitrey.danilau.foodrecipies.util

import by.dzmitrey.danilau.foodrecipies.repositories.IRecipeRepository
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


abstract class NetworkBoundSource<LocalType, RemoteType>(localSource: IRecipeRepository.LocalDataSource) {
    private val disposable = CompositeDisposable()
    lateinit var result: Flowable<Resource<LocalType>>

    init {
        val dBObservable: Flowable<LocalType> = Flowable.defer{
            loadfromDB().observeOn(Schedulers.computation())
        }
        val networkObservable: Single<LocalType> = Single.defer{
            loadFromRemote()
                .map (mapper())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnSuccess {
                    Timber.d("Result from remote: $it")
                    saveCallResult(it)
                }.onErrorReturn {
                    Timber.d("Error ${it.message}")
                    throw it
                }
        }
    }

    protected abstract fun loadFromRemote(): Single<RemoteType>

    protected abstract fun shouldFetch(data: LocalType): Boolean

    protected abstract fun loadfromDB(): Flowable<LocalType>

    protected abstract fun saveCallResult(data: LocalType)

    protected abstract fun mapper(): Function<RemoteType, LocalType>
}