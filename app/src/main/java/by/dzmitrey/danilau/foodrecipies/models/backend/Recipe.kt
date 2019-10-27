package by.dzmitrey.danilau.foodrecipies.models.backend

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("publisher")
    val publisher: String?,
    @SerializedName("title")
    val title: String?,
//    @SerializedName("ingredients")
//    private val ingredients: ArrayList<String>,
    @SerializedName("recipe_id")
    val id: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("social_rank")
    val socialRank: Double
)


