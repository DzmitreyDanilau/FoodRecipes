package by.dzmitrey.danilau.foodrecipies.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R


class RecipeViewHolder(view: View, private var onRecipeListener: OnRecipeListener) :
    RecyclerView.ViewHolder(view), View.OnClickListener {

    init {
        view.setOnClickListener(this)
    }

    var title: TextView = view.findViewById(R.id.recipe_title)
    var publisher: TextView = view.findViewById(R.id.recipe_publisher)
    var socialScore: TextView = view.findViewById(R.id.recipe_social_score)
    var dishImage: ImageView = view.findViewById(R.id.recipe_image)

    override fun onClick(v: View?) {
        onRecipeListener.onRecipeClick(adapterPosition)
    }
 }