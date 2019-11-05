package by.dzmitrey.danilau.foodrecipies.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.util.DEFAULT_SEARCH_CATEGORIES
import by.dzmitrey.danilau.foodrecipies.util.DEFAULT_SEARCH_CATEGORY_IMAGES
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import timber.log.Timber


const val RECIPE_TYPE = 1
const val LOADING_TYPE = 2
const val CATEGORY_TYPE = 3

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
            CATEGORY_TYPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_category_list_item, parent, false)
                return CategoryViewHolder(view, listener)
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
            (holder as RecipeViewHolder).bind(recipes[position])
        } else if (itemViewType == CATEGORY_TYPE) {
            (holder as CategoryViewHolder).bind(recipes[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return (when {
            recipes[position].title!! == "Loading" -> {
                LOADING_TYPE
            }
            recipes[position].socialRank == -1 -> {
                return CATEGORY_TYPE
            }
            else -> {
                RECIPE_TYPE
            }
        })
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

    fun displaySearchCategories() {
        val categoryList = mutableListOf<RecipeLocal>()
        for (categories in DEFAULT_SEARCH_CATEGORIES.indices) {
            val recipe = RecipeLocal(
                0,
                "",
                DEFAULT_SEARCH_CATEGORIES[categories],
                "",
                DEFAULT_SEARCH_CATEGORY_IMAGES[categories],
                -1
            )
            categoryList.add(recipe)
        }
        recipes.addAll(categoryList)
        notifyDataSetChanged()
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