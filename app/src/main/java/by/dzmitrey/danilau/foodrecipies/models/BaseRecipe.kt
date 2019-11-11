package by.dzmitrey.danilau.foodrecipies.models

interface BaseRecipe : DisplayableItem {
    val id: String
    val title: String?
}