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
import by.dzmitrey.danilau.foodrecipies.util.DEFAULT_SUB_CATEGORIES
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView
import timber.log.Timber

class RecipeSubCategoryRecyclerAdapter(
    private val listener: OnCategoriesListener.OnSubCategoryListener,
    private val category: String
) : RecyclerView.Adapter<RecipeSubCategoryRecyclerAdapter.SubcategoryViewHolder>(),
    IRecyclerViewAdapter {

    private var subCategories = mutableListOf<CategoriesLocal>()

    init {setCategoriesItem()}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SubcategoryViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.layout_category_list_item,
            parent,
            false
        ),
        listener
    )

    override fun getItemCount() = subCategories.size

    override fun onBindViewHolder(holder: SubcategoryViewHolder, position: Int) {
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


    inner class SubcategoryViewHolder(
        view: View,
        private val listener: OnCategoriesListener.OnSubCategoryListener
    ) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
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
            listener.onSubCategoryClick(categoryTitle.text.toString())
        }
    }
}
