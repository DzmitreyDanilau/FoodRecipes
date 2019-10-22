package by.dzmitrey.danilau.foodrecipies.models.backend

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeApi(
    @Json(name = "publisher")
    val publisher: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "ingredients")
    val ingredients: ArrayList<String>,
    @Json(name = "recipe_id")
    val id: String?,
    @Json(name = "image_url")
    val imageUrl: String?,
    @Json(name = "social_rank")
    val socialRank: Double
)