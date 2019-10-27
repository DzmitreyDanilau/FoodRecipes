package by.dzmitrey.danilau.foodrecipies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.models.backend.Recipe
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RecipeRecyclerAdapter(private val listener: OnRecipeListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var recipes = mutableListOf<Recipe>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_recipe_list_item, parent, false)
        return RecipeViewHolder(view, listener)
    }

    override fun getItemCount() = recipes.size ?: 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        recipes.forEach {
            (holder as RecipeViewHolder).title.text = it.title
            holder.publisher.text = it.publisher
            holder.socialScore.text = it.socialRank.toString()
            val glideRequest = RequestOptions().placeholder(R.drawable.ic_launcher_background)
            Glide.with(holder.dishImage.context)
                .setDefaultRequestOptions(glideRequest)
                .load(it.imageUrl)
                .into(holder.dishImage)
        }
    }

    fun setRecipes(recipesList: List<Recipe>) {
        recipes = recipesList as MutableList<Recipe>
        notifyDataSetChanged()
    }

}