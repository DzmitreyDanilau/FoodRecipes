package by.dzmitrey.danilau.foodrecipies.di.recipelist

import by.dzmitrey.danilau.foodrecipies.di.scopes.RecipeListScope
import by.dzmitrey.danilau.foodrecipies.network.RecipeApi
import by.dzmitrey.danilau.foodrecipies.repositories.RecipeListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class RecipeListRepositoryModule {
    @RecipeListScope
    @Provides
    fun provideRecipeListRepository(recipeApi: RecipeApi)
            = RecipeListRepository(recipeApi)

}