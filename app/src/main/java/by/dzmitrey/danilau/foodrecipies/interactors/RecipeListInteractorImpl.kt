package by.dzmitrey.danilau.foodrecipies.interactors

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.models.backend.Recipe
import by.dzmitrey.danilau.foodrecipies.repositories.IRecipeRepository
import io.reactivex.Single
import io.reactivex.SingleSource
import timber.log.Timber
import javax.inject.Inject

class RecipeListInteractorImpl @Inject constructor(
    private val networkDataSource: IRecipeRepository.NetworkDataSource,
    private val localDataSource: IRecipeRepository.LocalDataSource
) : IInteractor.RecipeListInteractor {
    private var recipeResponseList = mutableListOf<Recipe>()
    override fun fetchDataFromApi(query: String, page: Int): Single<List<Recipe>> {
        return networkDataSource.searchRecipesByApi(query, page)
            .doOnSuccess { Timber.d("Result: ${it.recipesList}") }
            .flatMap {
                recipeResponseList = it.recipesList as MutableList<Recipe>
                SingleSource<List<Recipe>> {
                    recipeResponseList }
            }
    }

    override fun fetchDataFromDB(): Single<List<RecipeLocal>> {
//        localDataSource.searchRecipesByDB()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun saveDataToDB(recipeList: List<RecipeLocal>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}