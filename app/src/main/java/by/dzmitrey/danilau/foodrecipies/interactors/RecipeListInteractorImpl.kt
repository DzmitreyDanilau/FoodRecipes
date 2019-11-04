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
    private val compositeDisposable = CompositeDisposable()

    override fun fetchData(query: String, page: Int): Flowable<List<RecipeLocal>> {
        return object : NetworkBoundSource<List<RecipeLocal>, RecipeSearchResponse>() {
            override fun loadFromRemote(): Single<RecipeSearchResponse> {
                return fetchDataFromRemote(query, page)
            }

            override fun shouldFetch(): Boolean {
                return true
            }

            override fun loadfromDB(): Flowable<List<RecipeLocal>> {
                return loadfromDB()
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
//        val networkObservable = networkDataSource.searchRecipesByApi(query, page)
//            .subscribeOn(Schedulers.io())
//            .map {
//                transformDataToAppModel(it)
//            }
//            .doOnSuccess {
//                Timber.d("Thread inside fetchData: ${Thread.currentThread().name}")
//                saveDataToDB(it)
//            }
//            .doOnError {
//                handleError(it)
//            }
//            .flatMap(Function<List<BaseRecipe>, SingleSource<List<RecipeLocal>>> {
//                Timber.d("Thread flatmap ${Thread.currentThread().name}")
//                return@Function Single.just(recipeResponseList)
//            })
//        return Flowable.concat(fetchDataFromDB(query),networkObservable)
    }

    private fun handleError(error: Throwable?) {
        Timber.d("Error ${error?.message}")
    }

    override fun shouldFetch(): Boolean {
        return false
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