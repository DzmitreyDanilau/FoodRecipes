package by.dzmitrey.danilau.foodrecipies.adapters

import by.dzmitrey.danilau.foodrecipies.models.BaseRecipe

interface IRecyclerViewAdapter {
    fun setItems(items:List<BaseRecipe>)
}