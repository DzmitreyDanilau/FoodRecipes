package by.dzmitrey.danilau.foodrecipies.models.modelsbackend

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("publisher")
    private val publisher: String?,
    @SerializedName("title")
    val title: String?,
//    @SerializedName("ingredients")
//    private val ingredients: ArrayList<String>,
    @SerializedName("recipe_id")
    private val id: String?,
    @SerializedName("image_url")
    private val imageUrl: String?,
    @SerializedName("social_rank")
    private val socialRank: Double
)


