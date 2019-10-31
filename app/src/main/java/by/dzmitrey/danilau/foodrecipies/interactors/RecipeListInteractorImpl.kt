package by.dzmitrey.danilau.foodrecipies.interactors

import by.dzmitrey.danilau.foodrecipies.models.BaseRecipe
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSearchResponse
import by.dzmitrey.danilau.foodrecipies.repositories.IRecipeRepository
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class RecipeListInteractorImpl @Inject constructor(
    private val networkDataSource: IRecipeRepository.NetworkDataSource,
    private val localDataSource: IRecipeRepository.LocalDataSource
) : IInteractor.RecipeListInteractor {
    private var recipeResponseList:MutableList<RecipeLocal>? = mutableListOf<RecipeLocal>()

    override fun fetchDataFromApi(query: String, page: Int): Single<List<RecipeLocal>> {


        return networkDataSource.searchRecipesByApi(query, page)

            .map {
                transformDataToAppModel(it)
            }
            .doOnSuccess {
                Timber.d("Thread inside fetchData: ${Thread.currentThread().name}")
                saveDataToDB(it)
            }
            .doOnError {
                handleError(it)
            }
            .subscribeOn(Schedulers.computation())
            .flatMap(Function<List<BaseRecipe>, SingleSource<List<RecipeLocal>>> {
                Timber.d("Thread flatmap ${Thread.currentThread().name}")
                return@Function Single.just(recipeResponseList)
            })
    }

    private fun handleError(error: Throwable?) {
        Timber.d("Error ${error?.message}")

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun shouldFetch(): Boolean {
        return false
    }

    override fun fetchDataFromDB(): Single<List<RecipeLocal>> {
//        localDataSource.searchRecipesByDB()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }


    override fun saveDataToDB(recipeList: List<RecipeLocal>) {
        localDataSource.save(recipeList[0])
    }

    override fun transformDataToAppModel(recipeSearchResponse: RecipeSearchResponse): List<RecipeLocal> {
        recipeSearchResponse.recipesList?.map {
            recipeResponseList?.add(
                RecipeLocal(
                    0,
                    it.publisher,
                    it.title,
                    it.id,
                    it.imageUrl,
                    it.socialRank.toInt()
                )
            )
        }
        return recipeResponseList!!
    }
}