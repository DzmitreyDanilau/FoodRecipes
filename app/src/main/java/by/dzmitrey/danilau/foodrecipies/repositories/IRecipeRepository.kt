package by.dzmitrey.danilau.foodrecipies.repositories

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.models.backend.Recipe
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSearchResponse
import io.reactivex.Single

interface IRecipeRepository {
    interface NetworkDataSource {
        fun searchRecipesByApi(query: String, page: Int): Single<RecipeSearchResponse>
    }

    interface LocalDataSource {
        fun searchRecipesByDB(query: String): Single<List<RecipeLocal>>
    }

}