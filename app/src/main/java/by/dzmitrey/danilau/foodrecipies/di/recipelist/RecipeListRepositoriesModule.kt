package by.dzmitrey.danilau.foodrecipies.di.recipelist

import by.dzmitrey.danilau.foodrecipies.di.scopes.FragmentScope
import by.dzmitrey.danilau.foodrecipies.network.RecipeApi
import by.dzmitrey.danilau.foodrecipies.repositories.IRecipeRepository
import by.dzmitrey.danilau.foodrecipies.repositories.RecipeListLocalDataSource
import by.dzmitrey.danilau.foodrecipies.repositories.RecipeListNetworkDataSource
import by.dzmitrey.danilau.foodrecipies.sources.local.RecipeDao
import dagger.Module
import dagger.Provides
import timber.log.Timber

@Module
class RecipeListRepositoriesModule {
    @FragmentScope
    @Provides
    fun provideNetworkRecipeListRepository(recipeApi: RecipeApi): IRecipeRepository.NetworkDataSource {
        return RecipeListNetworkDataSource(recipeApi)
    }

    @FragmentScope
    @Provides
    fun productRepository(productDao: RecipeDao): IRecipeRepository.LocalDataSource {
        Timber.d("Local data source entity init")
        return RecipeListLocalDataSource(productDao)
    }

}