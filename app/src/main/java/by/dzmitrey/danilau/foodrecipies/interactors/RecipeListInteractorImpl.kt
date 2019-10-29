package by.dzmitrey.danilau.foodrecipies.interactors

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.network.responses.RecipeSearchResponse
import by.dzmitrey.danilau.foodrecipies.repositories.IRecipeRepository
import by.dzmitrey.danilau.foodrecipies.util.NetworkBoundSource
import by.dzmitrey.danilau.foodrecipies.util.Resource
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class RecipeListInteractorImpl @Inject constructor(
    private val networkDataSource: IRecipeRepository.NetworkDataSource,
    private val localDataSource: IRecipeRepository.LocalDataSource
) : IInteractor.RecipeListInteractor {
    private var recipeResponseList = mutableListOf<RecipeLocal>()

    override fun fetchDataFromApi(query: String, page: Int): Flowable<Resource<List<RecipeLocal>>> {
        return Flowable.create(object :
            NetworkBoundSource<Resource<List<RecipeLocal>>, Resource<RecipeSearchResponse>>() {

        })
//        return networkDataSource.searchRecipesByApi(query, page)
//            .doOnSuccess { Timber.d("Request result: $it") }
//            .flatMap(Function<RecipeSearchResponse, SingleSource<List<RecipeLocal>>> {
//                transformDataToAppModel(it)
//                return@Function Single.just(recipeResponseList)
//            })
    }


    override fun fetchDataFromDB(): Single<List<RecipeLocal>> {
//        localDataSource.searchRecipesByDB()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun saveDataToDB(recipeList: List<RecipeLocal>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformDataToAppModel(recipeSearchResponse: RecipeSearchResponse) {
        recipeSearchResponse.recipesList?.map {
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
    }
}