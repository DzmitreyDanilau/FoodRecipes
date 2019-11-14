package by.dzmitrey.danilau.foodrecipies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.models.BaseRecipe
import by.dzmitrey.danilau.foodrecipies.models.app.CategoriesLocal
import by.dzmitrey.danilau.foodrecipies.util.DEFAULT_SEARCH_CATEGORIES
import by.dzmitrey.danilau.foodrecipies.util.DEFAULT_SEARCH_CATEGORY_IMAGES


class RecipeCategoryRecyclerAdapter(private val listener: OnCategoryListener) :
    RecyclerView.Adapter<CategoryViewHolder>(),IRecyclerViewAdapter {

    private var categories = mutableListOf<CategoriesLocal>()

    init {
        setCategoriesItem()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoryViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.layout_category_list_item,
            parent,
            false
        ),
        listener
    )

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun setItems(items: List<BaseRecipe>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun setCategoriesItem() {
        val categoryList = mutableListOf<CategoriesLocal>()
        for (categories in DEFAULT_SEARCH_CATEGORIES.indices) {
            val categoriesLocal = CategoriesLocal(
                DEFAULT_SEARCH_CATEGORIES[categories],
                DEFAULT_SEARCH_CATEGORY_IMAGES[categories]
            )
            categoryList.add(categoriesLocal)
        }
        categories.addAll(categoryList)
    }

}
