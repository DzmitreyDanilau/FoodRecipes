package by.dzmitrey.danilau.foodrecipies.sources.local

import androidx.room.TypeConverter

class Converters {
    companion object {

        @TypeConverter
        @JvmStatic
        fun toString(ingredientsList: List<String?>) =
            ingredientsList.map { it }.joinToString("//")

        @TypeConverter
        @JvmStatic
        fun stringToIngredientsList(ingredients: String?): List<String>? {
            return ingredients?.split("//")?.toList()
        }
    }
}