package by.dzmitrey.danilau.foodrecipies.network.responses

import by.dzmitrey.danilau.foodrecipies.models.modelsbackend.Recipe
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RecipeResponse (
    @SerializedName("recipe")
    @Expose()
    private val recipe: Recipe?

)


