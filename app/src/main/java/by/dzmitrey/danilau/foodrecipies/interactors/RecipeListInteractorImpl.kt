package by.dzmitrey.danilau.foodrecipies.interactors

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSearchResponse
import by.dzmitrey.danilau.foodrecipies.repositories.IRecipeRepository
import by.dzmitrey.danilau.foodrecipies.util.NetworkBoundSource
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import timber.log.Timber
import javax.inject.Inject

class RecipeListInteractorImpl @Inject constructor(
    private val networkDataSource: IRecipeRepository.NetworkDataSource,
    private val localDataSource: IRecipeRepository.LocalDataSource
) : IInteractor.RecipeListInteractor {
    private var recipeResponseList: MutableList<RecipeLocal>? = mutableListOf()

    override fun fetchData(query: String, page: Int): Flowable<List<RecipeLocal>> {
        return object : NetworkBoundSource<List<RecipeLocal>, RecipeSearchResponse>() {
            override fun loadFromRemote(): Single<RecipeSearchResponse> {
                return fetchDataFromRemote(query, page)
            }

            override fun shouldFetch(): Boolean {
                return true
            }

            override fun loadfromDB(): Flowable<List<RecipeLocal>> {
                return fetchDataFromDB(query)
            }

            override fun saveCallResult(data: List<RecipeLocal>) {
                saveDataToDB(data)
            }

            override fun mapper(): Function<RecipeSearchResponse, List<RecipeLocal>> {
                return Function {
                    transformDataToAppModel(it)
                }
            }
        }.getResult()
            .doOnError {
            handleError(it)
        }
    }

    override fun shouldFetch(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun handleError(error: Throwable?) {
        Timber.d("Error ${error?.message}")
    }

    override fun fetchDataFromDB(query: String): Flowable<List<RecipeLocal>> {
        return localDataSource.getRecipes(query)
    }

    override fun fetchDataFromRemote(query: String, page: Int): Single<RecipeSearchResponse> {
        return networkDataSource.searchRecipesByApi(query, page)
    }

    override fun saveDataToDB(recipeList: List<RecipeLocal>) {
        localDataSource.saveAllRecipes(recipeList)
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