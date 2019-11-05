package by.dzmitrey.danilau.foodrecipies.util

import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


abstract class NetworkBoundSource<LocalType, RemoteType> {
    private var result: Flowable<LocalType>
    private var dBObservable: Flowable<LocalType>
    private var networkObservable: Single<LocalType>

    init {
        dBObservable = loadfromDB().subscribeOn(Schedulers.computation())

        networkObservable = loadFromRemote()
            .map(mapper())
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .doOnSuccess {
                Timber.d("Result from remote: $it")
                saveCallResult(it)
            }
        result = readData()
    }

    private fun readData(): Flowable<LocalType> {
        val compositeDisposable = CompositeDisposable()
        if (shouldFetch()) {
            compositeDisposable.add(networkObservable.subscribe(
                {
                    Timber.d("Inside subscribe networkObservable: $it")
                },
                {
                    Timber.d("Error inside networkObservable: ${it.message}")
                }
            ))
        }
        return dBObservable
    }

    fun getResult() = result

    protected abstract fun loadFromRemote(): Single<RemoteType>

    protected abstract fun shouldFetch(): Boolean

    protected abstract fun loadfromDB(): Flowable<LocalType>

    protected abstract fun saveCallResult(data: LocalType)

    protected abstract fun mapper(): Function<RemoteType, LocalType>
}