package by.dzmitrey.danilau.foodrecipies.di.recipelist

import by.dzmitrey.danilau.foodrecipies.di.scopes.RecipeListScope
import by.dzmitrey.danilau.foodrecipies.network.RecipeApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RecipeListModule {
    @RecipeListScope
    @Provides
    fun providesAuthApi(retrofit: Retrofit): RecipeApi {
        return retrofit.create(RecipeApi::class.java)
    }
}