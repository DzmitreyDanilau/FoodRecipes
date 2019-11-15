package by.dzmitrey.danilau.foodrecipies.di.recipelist

import by.dzmitrey.danilau.foodrecipies.di.scopes.FragmentScope
import by.dzmitrey.danilau.foodrecipies.network.RecipeApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RecipeListNetworkModule {
    @FragmentScope
    @Provides
    fun provideRecipeApi(retrofit: Retrofit): RecipeApi {
        return retrofit.create(RecipeApi::class.java)
    }
}