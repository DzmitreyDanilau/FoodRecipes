package by.dzmitrey.danilau.foodrecipies.di.modules

import androidx.lifecycle.ViewModelProvider
import by.dzmitrey.danilau.foodrecipies.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory)
            : ViewModelProvider.Factory
}