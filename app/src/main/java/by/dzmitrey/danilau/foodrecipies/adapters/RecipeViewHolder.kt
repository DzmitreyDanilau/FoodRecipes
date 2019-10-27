package by.dzmitrey.danilau.foodrecipies.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.models.backend.Recipe


class RecipeViewHolder(view: View, private var onRecipeListener: OnRecipeListener) :
    RecyclerView.ViewHolder(view), View.OnClickListener {

    init {
        view.setOnClickListener(this)
    }

    private var title: TextView = view.findViewById(R.id.recipe_title)
    private var publisher: TextView = view.findViewById(R.id.recipe_publisher)
    private var socialScore: TextView = view.findViewById(R.id.recipe_social_score)
    private var dishImage: ImageView = view.findViewById(R.id.recipe_image)

    override fun onClick(v: View?) {
        onRecipeListener.onRecipeClick(adapterPosition)
    }

    fun bind(recipe: Recipe){
        title.text = recipe.title
        publisher.text = recipe.publisher
        socialScore.text = recipe.socialRank.toString()
        dishImage =

    }
}