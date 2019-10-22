package by.dzmitrey.danilau.foodrecipies.network.responses

import by.dzmitrey.danilau.foodrecipies.models.backend.Recipe
import com.google.gson.annotations.SerializedName

class RecipeResponse (
    @SerializedName("recipe")
    private val recipe: Recipe?

)


