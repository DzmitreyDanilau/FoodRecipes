package by.dzmitrey.danilau.foodrecipies.di.recipelist

import by.dzmitrey.danilau.foodrecipies.interactors.IInteractor
import by.dzmitrey.danilau.foodrecipies.interactors.RecipeListInteractorImpl
import by.dzmitrey.danilau.foodrecipies.repositories.IRecipeRepository
import dagger.Module
import dagger.Provides

@Module
class RecipeListInteractorsModule {
    @Provides
    fun provideRecipeListInteractor(
        networkDataSource: IRecipeRepository.NetworkDataSource,
        localDataSource: IRecipeRepository.LocalDataSource
    ): IInteractor.RecipeListInteractor {
        return RecipeListInteractorImpl(networkDataSource,localDataSource)
    }
}