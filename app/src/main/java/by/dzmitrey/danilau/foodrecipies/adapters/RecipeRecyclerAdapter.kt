package by.dzmitrey.danilau.foodrecipies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import timber.log.Timber


const val RECIPE_TYPE = 1
const val LOADING_TYPE = 2

class RecipeRecyclerAdapter(private val listener: OnRecipeListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var recipes = mutableListOf<RecipeLocal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            RECIPE_TYPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_recipe_list_item, parent, false)
                return RecipeViewHolder(view, listener)
            }
            LOADING_TYPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_loading_list_item, parent, false)
                return LoadingViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_recipe_list_item, parent, false)
                return RecipeViewHolder(view, listener)
            }

        }

    }

    override fun getItemCount() = recipes.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Timber.d("$recipes")
        val itemViewType = getItemViewType(position)
        if (itemViewType == RECIPE_TYPE) {
            bindRecipeViewHolder(holder, position)
        }
    }

    private fun bindRecipeViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
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

    override fun getItemViewType(position: Int): Int {
        return if (recipes[position].title!! == "Loading") {
            LOADING_TYPE
        } else {
            RECIPE_TYPE
        }
    }

    fun displayLoading() {
        if (!isLoading()) {
            val recipe = RecipeLocal(0, "", "Loading")
            val loadingList: MutableList<RecipeLocal> = ArrayList()
            loadingList.add(recipe)
            recipes = loadingList
            notifyDataSetChanged()
        }
    }

    private fun isLoading(): Boolean {
        if (recipes.size > 0) {
            if (recipes[(recipes.size - 1)].title.equals("Loading")) {
                return true
            }
        }

        return false
    }

    fun setRecipes(recipesList: List<RecipeLocal>) {
        recipes = recipesList as MutableList<RecipeLocal>
        notifyDataSetChanged()
    }
}