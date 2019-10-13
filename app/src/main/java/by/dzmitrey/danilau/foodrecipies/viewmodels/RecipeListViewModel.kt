package by.dzmitrey.danilau.foodrecipies.viewmodels

import androidx.lifecycle.ViewModel
import by.dzmitrey.danilau.foodrecipies.repositories.RecipeListRepository
import javax.inject.Inject

class RecipeListViewModel @Inject constructor(private val repository: RecipeListRepository) :
    ViewModel() {

    fun getRecipes() = repository.getRecipesFromRepository()
}