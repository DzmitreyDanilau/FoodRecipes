package by.dzmitrey.danilau.foodrecipies.adapters

interface OnRecipeListener {
    fun onRecipeClick(position: Int)
    fun onCategoryClick(category: String)
}