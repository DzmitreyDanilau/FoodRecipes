package by.dzmitrey.danilau.foodrecipies.network.responses


import by.dzmitrey.danilau.foodrecipies.models.modelsbackend.RecipeMoshi
import com.squareup.moshi.Json

class RecipeSearchResponseMoshi(
    @Json(name = "count")
    private val count: Int,
    @Json(name="recipes")
    val recipesList: List<RecipeMoshi>?
)
