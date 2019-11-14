package by.dzmitrey.danilau.foodrecipies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.adapters.RecipeSubCategoryRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_recipe_category.*
import timber.log.Timber

class RecipeSubCategoryFragment : BaseFragment() {
    private var clickedCategory: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            clickedCategory = it.getString(getString(R.string.intent_message))
            Timber.d("Clecked Category inside subcategory Fragment: $clickedCategory")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = recycler_view_recipe_list
        initRecyclerView(
            RecipeSubCategoryRecyclerAdapter(
                this@RecipeSubCategoryFragment,
                clickedCategory!!
            )
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = RecipeSubCategoryFragment()
    }
}
