package by.dzmitrey.danilau.foodrecipies.util

import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


abstract class NetworkBoundSource<LocalType, RemoteType>(private val emitter: FlowableEmitter<Resource<LocalType>>) {
    private val disposable = CompositeDisposable()

    init {
        val dataTest = loadfromDB()
            .map {
                Resource.Loading<LocalType>()
            }.subscribe {
                emitter.onNext(it)
            }
        disposable.add(dataTest)

        loadFromRemote()
            .map(mapper())
            .subscribeOn(Schedulers.newThread())
            .observeOn(Schedulers.io())
            .subscribe(
                {
                    disposable.delete(dataTest)
                    saveCallResult(it)
                    loadfromDB().map { localDataType ->
                        Resource.Success(localDataType)
                    }
                        .subscribe({ emitter.onNext(it) }, { Timber.d("Error ${it.message}") })
                },
                {Timber.d("Error ${it.message}")})
    }

    protected abstract fun loadFromRemote(): Single<RemoteType>

    protected abstract fun shouldFetch(data: LocalType): Boolean

    protected abstract fun loadfromDB(): Flowable<LocalType>

    protected abstract fun saveCallResult(data: LocalType)

    protected abstract fun mapper(): Function<RemoteType, LocalType>
}