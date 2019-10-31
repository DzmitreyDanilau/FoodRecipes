package by.dzmitrey.danilau.foodrecipies.di.modules

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import by.dzmitrey.danilau.foodrecipies.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @ApplicationScope
    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @ApplicationScope
    @Provides
    fun provideConnectivityManager(application: Application): ConnectivityManager {
        return application.applicationContext
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

}