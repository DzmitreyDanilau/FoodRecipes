package by.dzmitrey.danilau.foodrecipies.models.backend

import by.dzmitrey.danilau.foodrecipies.models.BaseRecipe
import com.google.gson.annotations.SerializedName

data class RecipeApiResponse(
    @SerializedName("publisher")
    val publisher: String?,
    @SerializedName("title")
    override val title: String?,
    @SerializedName("recipe_id")
    override val id: String,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("social_rank")
    val socialRank: Double
) : BaseRecipe

