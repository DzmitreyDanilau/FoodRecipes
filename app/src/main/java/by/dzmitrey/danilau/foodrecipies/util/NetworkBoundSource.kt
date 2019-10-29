package by.dzmitrey.danilau.foodrecipies.util

import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.Single
import io.reactivex.functions.Function


abstract class NetworkBoundSource<LocalType, RemoteType>(private val emmiter: FlowableEmitter<Resource<LocalType>>) {

    init {
        val firstDataDisposable = loadfromDB()

    }

    protected abstract fun loadFromRemote(): Single<RemoteType?>?

    protected abstract fun shouldFetch(data: LocalType): Boolean

    protected abstract fun loadfromDB(): Flowable<LocalType?>?

    protected abstract fun saveCallResult(data: RemoteType?)

    protected abstract fun mapper(): Function<RemoteType, LocalType>
}