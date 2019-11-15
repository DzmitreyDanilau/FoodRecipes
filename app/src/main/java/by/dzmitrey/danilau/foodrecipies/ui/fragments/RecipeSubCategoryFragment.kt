package by.dzmitrey.danilau.foodrecipies.ui.fragments

import android.content.Context
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
        Timber.d("fragment: onCreate")
        arguments?.let {
            clickedCategory = it.getString(getString(R.string.intent_message))
            Timber.d("Clecked Category inside subcategory Fragment: $clickedCategory")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("fragment: onCreateView")

        return inflater.inflate(R.layout.fragment_recipe_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("fragment: onViewCreated")
        recyclerView = recycler_view_recipe_list
        initRecyclerView(
            RecipeSubCategoryRecyclerAdapter(
                this@RecipeSubCategoryFragment,
                clickedCategory!!
            )
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("fragment: onAttach")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("fragment: onActivityCreated")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("fragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("fragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("fragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("fragment: onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("fragment: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("fragment: onDetach")

    }

    companion object {
        @JvmStatic
        fun newInstance() = RecipeSubCategoryFragment()
    }
}
