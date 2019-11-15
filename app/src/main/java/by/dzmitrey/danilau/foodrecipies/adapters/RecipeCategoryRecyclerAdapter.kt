package by.dzmitrey.danilau.foodrecipies.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.models.BaseRecipe
import by.dzmitrey.danilau.foodrecipies.models.app.CategoriesLocal
import by.dzmitrey.danilau.foodrecipies.util.DEFAULT_SEARCH_CATEGORIES
import by.dzmitrey.danilau.foodrecipies.util.DEFAULT_SEARCH_CATEGORY_IMAGES
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView


class RecipeCategoryRecyclerAdapter(private val listener: OnCategoriesListener.OnCategoryListener) :
    RecyclerView.Adapter<RecipeCategoryRecyclerAdapter.CategoryViewHolder>(),IRecyclerViewAdapter {

    private var categories = mutableListOf<CategoriesLocal>()

    init {setCategoriesItem()}

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

    inner class CategoryViewHolder(
        view: View,
        private val listener: OnCategoriesListener.OnCategoryListener
    ) :
        RecyclerView.ViewHolder(view), View.OnClickListener {

        init {
            view.setOnClickListener(this)
        }

        private var categoryImage: CircleImageView = view.findViewById(R.id.category_image)
        private var categoryTitle: TextView = view.findViewById(R.id.category_title)

        fun bind(category: CategoriesLocal) {
            categoryTitle.text = category.categoryTitle
            val glideRequest = RequestOptions().placeholder(R.drawable.ic_launcher_background)
            val picturePath = Uri.parse(
                "android.resource://by.dzmitrey.danilau.foodrecipies/drawable/" +
                        category.categoryImage
            )
            Glide.with(categoryImage.context)
                .setDefaultRequestOptions(glideRequest)
                .load(picturePath)
                .error(R.drawable.ic_login_error)
                .into(categoryImage)
        }

        override fun onClick(v: View?) {
            listener.onCategoryClick(categoryTitle.text.toString())
        }

    }
}
