package by.dzmitrey.danilau.foodrecipies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.models.BaseRecipe
import by.dzmitrey.danilau.foodrecipies.models.app.CategoriesLocal
import by.dzmitrey.danilau.foodrecipies.util.DEFAULT_SUB_CATEGORIES
import timber.log.Timber

class RecipeSubCategoryRecyclerAdapter(
    private val listener: OnCategoryListener,
    private val category: String
) : RecyclerView.Adapter<CategoryViewHolder>(), IRecyclerViewAdapter {

    private var subCategories = mutableListOf<CategoriesLocal>()

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

    override fun getItemCount() = subCategories.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(subCategories[position])
    }

    override fun setItems(items: List<BaseRecipe>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun setCategoriesItem() {
        val tmpList = arrayListOf<CategoriesLocal>()
        DEFAULT_SUB_CATEGORIES[category]?.forEach {
            val categoriesLocal = CategoriesLocal(it, it)
            tmpList.add(categoriesLocal)
        }
        Timber.d("SubCategories List: $subCategories")
        subCategories.addAll(tmpList)
    }
}
