package by.dzmitrey.danilau.foodrecipies.di.recipelist

import by.dzmitrey.danilau.foodrecipies.di.scopes.RecipeListScope
import by.dzmitrey.danilau.foodrecipies.repositories.RecipeListRepository
import dagger.Binds
import dagger.Module

@Module
class RecipeListRepositoryModule {
    @RecipeListScope
    @Binds
    fun provideRecipeListRepository() = RecipeListRepository()
}