package by.dzmitrey.danilau.foodrecipies.network.responses


import by.dzmitrey.danilau.foodrecipies.models.backend.RecipeApi
import com.squareup.moshi.Json

class RecipeSearchResponseMoshi(
    @Json(name = "count")
    private val count: Int,
    @Json(name="recipes")
    val recipesList: List<RecipeApi>?
)
