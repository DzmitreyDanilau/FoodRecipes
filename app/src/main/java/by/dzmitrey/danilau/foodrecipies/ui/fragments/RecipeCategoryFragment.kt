package by.dzmitrey.danilau.foodrecipies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.adapters.OnCategoriesListener
import by.dzmitrey.danilau.foodrecipies.adapters.RecipeCategoryRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_recipe_category.*

class RecipeCategoryFragment : BaseFragment(), OnCategoriesListener.OnCategoryListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = recycler_view_recipe_list
        initRecyclerView(RecipeCategoryRecyclerAdapter(this@RecipeCategoryFragment))
    }

    override fun onCategoryClick(category: String) {
        this.category = category
        val listener = activity
        if (listener is OnCategoriesListener) {
            listener
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RecipeCategoryFragment()
    }
}