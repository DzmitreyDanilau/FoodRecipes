package by.dzmitrey.danilau.foodrecipies.models

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("title")
     val title: String?,
    @SerializedName("publisher")
    private val publisher: String?,
    @SerializedName("ingredients")
    private val ingredients: ArrayList<String>,
    @SerializedName("recipe_id")
    private val id: Int,
    @SerializedName("image_url")
    private val imageUrl: String?,
    @SerializedName("social_rank")
    private val socialRank: Double
)


