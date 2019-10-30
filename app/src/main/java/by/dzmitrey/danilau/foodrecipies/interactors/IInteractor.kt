package by.dzmitrey.danilau.foodrecipies.interactors

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSearchResponse
import io.reactivex.Single

interface IInteractor {
    interface RecipeListInteractor {
        fun fetchDataFromApi(query: String, page: Int): Single<List<RecipeLocal>>
        fun fetchDataFromDB(): Single<List<RecipeLocal>>
        fun saveDataToDB(recipeList: List<RecipeLocal>)
        fun transformDataToAppModel(recipeSearchResponse: RecipeSearchResponse)
    }
}