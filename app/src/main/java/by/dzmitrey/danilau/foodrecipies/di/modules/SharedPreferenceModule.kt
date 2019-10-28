package by.dzmitrey.danilau.foodrecipies.di.modules

import android.app.Application
import by.dzmitrey.danilau.foodrecipies.di.scopes.ApplicationScope
import by.dzmitrey.danilau.foodrecipies.sources.local.ILocalStorage
import by.dzmitrey.danilau.foodrecipies.sources.local.SharedPreferenceStorage
import dagger.Module
import dagger.Provides

@Module
class SharedPreferenceModule {
    @ApplicationScope
    @Provides
    fun provideSharedPreference(application: Application): ILocalStorage.SharedPreferencesStorage {
        return SharedPreferenceStorage(application)
    }
}