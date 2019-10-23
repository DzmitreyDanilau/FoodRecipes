package by.dzmitrey.danilau.foodrecipies.interactors

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.models.backend.Recipe
import io.reactivex.Single

interface IInteractor {
    interface RecipeListInteractor {
        fun fetchDataFromApi(query:String, page:Int): Single<List<Recipe>>
        fun fetchDataFromDB(): Single<List<RecipeLocal>>
        fun saveDataToDB(recipeList: List<RecipeLocal>)
    }
}