package by.dzmitrey.danilau.foodrecipies.di.recipelist

import by.dzmitrey.danilau.foodrecipies.network.RecipeApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RecipeListNetworkModule {
    @Provides
    fun provideRecipeApi(retrofit: Retrofit): RecipeApi {
        return retrofit.create(RecipeApi::class.java)
    }
}