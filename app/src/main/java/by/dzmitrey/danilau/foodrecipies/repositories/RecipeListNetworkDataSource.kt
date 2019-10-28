package by.dzmitrey.danilau.foodrecipies.repositories

import by.dzmitrey.danilau.foodrecipies.network.RecipeApi
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSearchResponse
import io.reactivex.Single
import javax.inject.Inject

class RecipeListNetworkDataSource @Inject constructor(private val recipeApi: RecipeApi) :
    IRecipeRepository.NetworkDataSource {
    override fun searchRecipesByApi(query: String, page: Int): Single<RecipeSearchResponse> {
        return recipeApi.searchRecipes(by.dzmitrey.danilau.foodrecipies.util.API_KEY, query, page)
    }
}
