package by.dzmitrey.danilau.foodrecipies.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.adapters.OnCategoryListener
import by.dzmitrey.danilau.foodrecipies.adapters.RecipeCategoryRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_recipe_category.*
import timber.log.Timber

class RecipeCategoryFragment : BaseFragment() {


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
        if (listener is OnCategoryListener) {
            listener.onCategoryClick(category)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RecipeCategoryFragment()
    }
}