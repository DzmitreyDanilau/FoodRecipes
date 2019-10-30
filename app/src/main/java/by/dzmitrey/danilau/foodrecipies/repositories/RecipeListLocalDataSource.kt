package by.dzmitrey.danilau.foodrecipies.repositories

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.sources.local.RecipeDao
import io.reactivex.Single
import javax.inject.Inject

class RecipeListLocalDataSource @Inject constructor(private val recipeDao: RecipeDao) :
    IRecipeRepository.LocalDataSource {
    override fun save(item: RecipeLocal): Single<Long> {
        val result = recipeDao.save(item)
        return result

    }
}