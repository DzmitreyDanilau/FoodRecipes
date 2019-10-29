package by.dzmitrey.danilau.foodrecipies.interactors

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSearchResponse
import by.dzmitrey.danilau.foodrecipies.repositories.IRecipeRepository
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.functions.Function
import timber.log.Timber
import javax.inject.Inject

class RecipeListInteractorImpl @Inject constructor(
    private val networkDataSource: IRecipeRepository.NetworkDataSource,
    private val localDataSource: IRecipeRepository.LocalDataSource
) : IInteractor.RecipeListInteractor {
    private var recipeResponseList = mutableListOf<RecipeLocal>()

    override fun fetchDataFromApi(query: String, page: Int): Single<List<RecipeLocal>> {
        return networkDataSource.searchRecipesByApi(query, page)
            .doOnSuccess { Timber.d("Request result: $it") }
            .flatMap(Function<RecipeSearchResponse, SingleSource<List<RecipeLocal>>> {
                it.recipesList?.map {
                    recipeResponseList.add(
                        RecipeLocal(
                            0,
                            it.publisher,
                            it.title,
                            null,
                            it.id,
                            it.imageUrl,
                            it.socialRank.toInt()
                        )
                    )
                }
                return@Function Single.just(recipeResponseList)
            })

    }


    override fun fetchDataFromDB(): Single<List<RecipeLocal>> {
//        localDataSource.searchRecipesByDB()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun saveDataToDB(recipeList: List<RecipeLocal>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}