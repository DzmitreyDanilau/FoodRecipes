package by.dzmitrey.danilau.foodrecipies.network.responses

import by.dzmitrey.danilau.foodrecipies.models.modelsbackend.RecipeMoshi
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse(
    @SerializedName("count")
    @Expose
    private val count: Int,
    @SerializedName("recipes")
    @Expose
    val recipesList: List<RecipeMoshi>?
)
