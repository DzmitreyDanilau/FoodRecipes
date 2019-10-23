package by.dzmitrey.danilau.foodrecipies.repositories

import by.dzmitrey.danilau.foodrecipies.models.backend.Recipe
import by.dzmitrey.danilau.foodrecipies.network.RecipeApi
import io.reactivex.Single
import javax.inject.Inject

class RecipeListNetworkDataSource @Inject constructor(private val recipeApi: RecipeApi) :
    IRecipeRepository.NetworkDataSource{
    override fun searchRecipesByApi(query: String, page: Int): Single<List<Recipe>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
