package by.dzmitrey.danilau.foodrecipies.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import timber.log.Timber


class RecipeViewHolder(view: View, private var onRecipeListener: OnRecipeListener) :
    RecyclerView.ViewHolder(view), View.OnClickListener {

    init {
        view.setOnClickListener(this)
    }

    var title: TextView = view.findViewById(R.id.recipe_title)
    var publisher: TextView = view.findViewById(R.id.recipe_publisher)
    var socialScore: TextView = view.findViewById(R.id.recipe_social_score)
    var dishImage: ImageView = view.findViewById(R.id.recipe_image)

    fun bind(recipe: RecipeLocal) {
        title.text = recipe.title
        publisher.text = recipe.publisher
        socialScore.text = recipe.socialRank.toString()
        val glideRequest = RequestOptions().placeholder(R.drawable.ic_launcher_background)
        val imageUrl = recipe.imageUrl
        Timber.d("$imageUrl")
        Glide.with(dishImage.context)
            .setDefaultRequestOptions(glideRequest)
            .load(imageUrl)
            .error(R.drawable.ic_login_error)
            .into(dishImage)
    }

    override fun onClick(v: View?) {
        onRecipeListener.onRecipeClick(adapterPosition)
    }
}