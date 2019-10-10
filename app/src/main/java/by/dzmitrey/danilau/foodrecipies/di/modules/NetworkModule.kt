package by.dzmitrey.danilau.foodrecipies.di.modules

import by.dzmitrey.danilau.foodrecipies.network.RecipeApi
import by.dzmitrey.danilau.foodrecipies.di.scopes.ApplicationScope
import by.dzmitrey.danilau.foodrecipies.util.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

@Module
class NetworkModule {
    @ApplicationScope
    @Provides
    fun provideService(retrofit: Retrofit): RecipeApi {
        return retrofit.create(RecipeApi::class.java)
    }

    @ApplicationScope
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @ApplicationScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        Timber.d("OkHttpClient created")
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }
}