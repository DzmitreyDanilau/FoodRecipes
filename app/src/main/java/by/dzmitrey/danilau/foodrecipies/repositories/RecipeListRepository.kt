package by.dzmitrey.danilau.foodrecipies.repositories

import androidx.lifecycle.MutableLiveData
import by.dzmitrey.danilau.foodrecipies.models.Recipe
import javax.inject.Inject

class RecipeListRepository @Inject constructor(val recipesList: MutableLiveData<List<Recipe>>) {

    fun getRecipesFromRepository() = recipesList
}