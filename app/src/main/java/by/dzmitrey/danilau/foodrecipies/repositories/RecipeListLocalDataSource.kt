package by.dzmitrey.danilau.foodrecipies.repositories

import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.sources.local.RecipeDao
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class RecipeListLocalDataSource @Inject constructor(private val recipeDao: RecipeDao) :
    IRecipeRepository.LocalDataSource {
    override fun save(item: RecipeLocal) {
        recipeDao.save(item)
    }

    override fun saveAllRecipes(itemsList: List<RecipeLocal>) {
        recipeDao.saveAll(itemsList)
    }

    override fun getRecipes(query: String): Flowable<List<RecipeLocal>> {
        return recipeDao.getRecipes()
    }
}