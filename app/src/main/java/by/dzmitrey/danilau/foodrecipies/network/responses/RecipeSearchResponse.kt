package by.dzmitrey.danilau.foodrecipies.network.responses

import by.dzmitrey.danilau.foodrecipies.models.backend.Recipe
import by.dzmitrey.danilau.foodrecipies.models.backend.RecipeApi
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse(
    @SerializedName("count")
    private val count: Int,
    @SerializedName("recipes")
    val recipesList: List<Recipe>?
)
