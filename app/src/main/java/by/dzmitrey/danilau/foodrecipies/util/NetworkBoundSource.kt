package by.dzmitrey.danilau.foodrecipies.util

import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.functions.Function


abstract class NetworkBoundSource<LocalType, RemoteType> {

    init {
    }

    protected abstract fun getRemote(): Single<RemoteType?>?

    protected abstract fun getLocal(): Flowable<RemoteType?>?

    protected abstract fun saveCallResult(data: RemoteType?)

    protected abstract fun mapper(): Function<LocalType, RemoteType>
}