package by.dzmitrey.danilau.foodrecipies.repositories

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSearchResponse
import io.reactivex.Single

interface IRecipeRepository {
    interface NetworkDataSource {
        fun searchRecipesByApi(query: String, page: Int): Single<RecipeSearchResponse>
    }

    interface LocalDataSource {
        fun saveAll(itemsList: List<RecipeLocal>):Single<List<Long>>
    }

}