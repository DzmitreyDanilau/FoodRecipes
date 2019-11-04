package by.dzmitrey.danilau.foodrecipies.interactors

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSearchResponse
import io.reactivex.Flowable
import io.reactivex.Single

interface IInteractor {
    interface RecipeListInteractor {
        fun fetchData(query: String, page: Int): Flowable<List<RecipeLocal>>
        fun fetchDataFromDB(query: String): Flowable<List<RecipeLocal>>
        fun fetchDataFromRemote(query: String, page: Int): Single<RecipeSearchResponse>
        fun saveDataToDB(recipeList: List<RecipeLocal>)
        fun transformDataToAppModel(recipeSearchResponse: RecipeSearchResponse): List<RecipeLocal>
        fun shouldFetch(): Boolean
    }
}