package by.dzmitrey.danilau.foodrecipies.network.responses

import by.dzmitrey.danilau.foodrecipies.models.backend.RecipeApiResponse
import com.google.gson.annotations.SerializedName

class RecipeResponse (
    @SerializedName("recipe")
    private val recipe: RecipeApiResponse?

)


