package by.dzmitrey.danilau.foodrecipies.repositories

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.sources.local.RecipeDao
import io.reactivex.Single
import javax.inject.Inject

class RecipeListLocalDataSource @Inject constructor(reipeDao: RecipeDao) :
    IRecipeRepository.LocalDataSource {
    override fun searchRecipesByDB(query: String): Single<List<RecipeLocal>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}