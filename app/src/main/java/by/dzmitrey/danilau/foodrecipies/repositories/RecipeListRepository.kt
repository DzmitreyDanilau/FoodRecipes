package by.dzmitrey.danilau.foodrecipies.repositories

import by.dzmitrey.danilau.foodrecipies.network.RecipeApi
import by.dzmitrey.danilau.foodrecipies.util.API_KEY
import by.dzmitrey.danilau.foodrecipies.util.API_KEY2
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class RecipeListRepository @Inject constructor(private val recipeApi: RecipeApi) {

    fun searchRecipes(query: String, page: Int) =
        recipeApi.serchRecipe(API_KEY2, query, page)
            .flatMap {
                Timber.d("${it.recipesList}")
                Observable.fromArray(it.recipesList)
            }
}