package by.dzmitrey.danilau.foodrecipies.util

import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


abstract class NetworkBoundSource<LocalType, RemoteType> {
    private var result: Flowable<LocalType>

    init {
        val dBObservable: Flowable<LocalType> = Flowable.defer {
            loadfromDB().subscribeOn(Schedulers.computation())
        }
        val networkObservable: Single<LocalType> = Single.defer {
            loadFromRemote()
                .map(mapper())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnSuccess {
                    Timber.d("Result from remote: $it")
                    saveCallResult(it)
                }

        }
        result = if (shouldFetch()) {
            networkObservable.toFlowable()
        } else {
            dBObservable
        }
    }

    fun getResult() = result

    protected abstract fun loadFromRemote(): Single<RemoteType>

    protected abstract fun shouldFetch(): Boolean

    protected abstract fun loadfromDB(): Flowable<LocalType>

    protected abstract fun saveCallResult(data: LocalType)

    protected abstract fun mapper(): Function<RemoteType, LocalType>
}