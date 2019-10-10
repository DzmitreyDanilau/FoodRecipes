package by.dzmitrey.danilau.foodrecipies.network.responses

import by.dzmitrey.danilau.foodrecipies.models.Recipe
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RecipeSerchResponse(
    @SerializedName("count")
    @Expose
    private val count: Int,
    @SerializedName("recipes")
    @Expose

    private val recipesList: List<Recipe>?
)
