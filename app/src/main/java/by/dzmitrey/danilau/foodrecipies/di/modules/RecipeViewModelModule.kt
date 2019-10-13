package by.dzmitrey.danilau.foodrecipies.di.modules

import androidx.lifecycle.ViewModel
import by.dzmitrey.danilau.foodrecipies.di.ViewModelKey
import by.dzmitrey.danilau.foodrecipies.viewmodels.RecipeListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RecipeViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RecipeListViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: RecipeListViewModel): ViewModel
}