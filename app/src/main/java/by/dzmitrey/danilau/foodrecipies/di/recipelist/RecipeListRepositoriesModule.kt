package by.dzmitrey.danilau.foodrecipies.di.recipelist

import by.dzmitrey.danilau.foodrecipies.network.RecipeApi
import by.dzmitrey.danilau.foodrecipies.repositories.IRecipeRepository
import by.dzmitrey.danilau.foodrecipies.repositories.RecipeListLocalDataSource
import by.dzmitrey.danilau.foodrecipies.repositories.RecipeListNetworkDataSource
import by.dzmitrey.danilau.foodrecipies.sources.local.RecipeDao
import dagger.Module
import dagger.Provides

@Module
class RecipeListRepositoriesModule {
    @Provides
    fun provideNetworkRecipeListRepository(recipeApi: RecipeApi): IRecipeRepository.NetworkDataSource {
        return RecipeListNetworkDataSource(recipeApi)
    }

    @Provides
    fun provideLocalRecipeListRepository(recipeDao: RecipeDao): IRecipeRepository.LocalDataSource {
        return RecipeListLocalDataSource(recipeDao)
    }
}