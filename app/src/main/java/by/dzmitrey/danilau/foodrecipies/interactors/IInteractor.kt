package by.dzmitrey.danilau.foodrecipies.interactors

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.models.backend.RecipeApiResponse
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSearchResponse
import by.dzmitrey.danilau.foodrecipies.util.Resource
import io.reactivex.Flowable
import io.reactivex.Single

interface IInteractor {
    interface RecipeListInteractor {
        fun fetchDataFromApi(query: String, page: Int): Flowable<Resource<List<RecipeLocal>>>
        fun fetchDataFromDB(): Single<List<RecipeLocal>>
        fun saveDataToDB(recipeList: List<RecipeLocal>)
        fun transformDataToAppModel(recipeSearchResponse: RecipeSearchResponse)
    }
}