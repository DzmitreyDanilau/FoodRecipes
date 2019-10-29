package by.dzmitrey.danilau.foodrecipies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import timber.log.Timber

class RecipeRecyclerAdapter(private val listener: OnRecipeListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var recipes = mutableListOf<RecipeLocal>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_recipe_list_item, parent, false)
        return RecipeViewHolder(view, listener)
    }

    override fun getItemCount() = recipes.size ?: 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Timber.d("$recipes")
        (holder as RecipeViewHolder).title.text = recipes[position].title
        holder.publisher.text = recipes[position].publisher
        holder.socialScore.text = recipes[position].socialRank.toString()
        val glideRequest = RequestOptions().placeholder(R.drawable.ic_launcher_background)
        val imageUrl = recipes[position].imageUrl
        Timber.d("$imageUrl")
        Glide.with(holder.dishImage.context)
            .setDefaultRequestOptions(glideRequest)
            .load(recipes[position].imageUrl)
            .error(R.drawable.ic_login_error)
            .into(holder.dishImage)
    }

    fun setRecipes(recipesList: List<RecipeLocal>) {
        recipes = recipesList as MutableList<RecipeLocal>
        notifyDataSetChanged()
    }

}