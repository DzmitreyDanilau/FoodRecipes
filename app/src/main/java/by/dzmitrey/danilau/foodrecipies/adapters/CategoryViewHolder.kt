package by.dzmitrey.danilau.foodrecipies.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.layout_category_list_item.view.*

class CategoryViewHolder(view: View, private val listener: OnRecipeListener) :
    RecyclerView.ViewHolder(view),
    View.OnClickListener {

//    var categoryImage:CircleImageView = view.findViewById(R.id.category_image)
    var categoryTitle: TextView = view.findViewById(R.id.category_title)

    override fun onClick(v: View?) {
        listener.onCategoryClick(categoryTitle.text.toString())
    }
}