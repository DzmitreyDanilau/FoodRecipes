package by.dzmitrey.danilau.foodrecipies.repositories

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.sources.local.RecipeDao
import io.reactivex.Single
import javax.inject.Inject

class RecipeListLocalDataSource @Inject constructor(private val recipeDao: RecipeDao) :
    IRecipeRepository.LocalDataSource {
    override fun saveAll(itemsList: List<RecipeLocal>):Single<List<Long>> {
        return recipeDao.saveAll(itemsList)
    }
}