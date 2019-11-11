package by.dzmitrey.danilau.foodrecipies.adapters

import android.net.Uri
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

class CategoryViewHolder(view: View, private val listener: OnRecipeListener) :
    RecyclerView.ViewHolder(view),
    View.OnClickListener {
    init {
        view.setOnClickListener(this)
    }

    var categoryImage: CircleImageView = view.findViewById(R.id.category_image)
    var categoryTitle: TextView = view.findViewById(R.id.category_title)


    fun bind(recipe: RecipeLocal) {
        categoryTitle.text = recipe.title
        val glideRequest = RequestOptions().placeholder(R.drawable.ic_launcher_background)
        val picturePath = Uri.parse(
            "android.resource://by.dzmitrey.danilau.foodrecipies/drawable/" +
                    recipe.imageUrl
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