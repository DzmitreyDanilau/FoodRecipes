package by.dzmitrey.danilau.foodrecipies.di.modules

import androidx.lifecycle.ViewModelProvider
import by.dzmitrey.danilau.foodrecipies.di.scopes.ApplicationScope
import by.dzmitrey.danilau.foodrecipies.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @ApplicationScope
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory)
            : ViewModelProvider.Factory
}