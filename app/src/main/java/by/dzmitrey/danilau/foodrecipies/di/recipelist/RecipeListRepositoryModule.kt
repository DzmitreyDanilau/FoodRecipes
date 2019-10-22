package by.dzmitrey.danilau.foodrecipies.di.recipelist

import by.dzmitrey.danilau.foodrecipies.network.RecipeApi
import by.dzmitrey.danilau.foodrecipies.repositories.IRecipeRepository
import by.dzmitrey.danilau.foodrecipies.repositories.RecipeListNetworkDataSource
import dagger.Module
import dagger.Provides

@Module
class RecipeListRepositoryModule {
    @Provides
    fun provideRecipeListRepository(recipeApi: RecipeApi): IRecipeRepository {
        return RecipeListNetworkDataSource(recipeApi)
    }
}