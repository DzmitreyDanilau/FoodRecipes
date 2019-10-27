package by.dzmitrey.danilau.foodrecipies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.models.backend.Recipe

class RecipeRecyclerAdapter(val recipeList: List<Recipe>, val listener: OnRecipeListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var recipes = mutableListOf<Recipe>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_recipe_list_item, parent, false)
        return RecipeViewHolder(view, listener)
    }

    override fun getItemCount() = recipeList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    fun setRecipes(recipesList: List<Recipe>) {
        recipes = recipesList as MutableList<Recipe>
        notifyDataSetChanged()
    }
}