package by.dzmitrey.danilau.foodrecipies.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.adapters.OnCategoriesListener
import by.dzmitrey.danilau.foodrecipies.adapters.RecipeCategoryRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_recipe_category.*
import timber.log.Timber

class RecipeCategoryFragment : BaseFragment(), OnCategoriesListener.OnCategoryListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("Category fragment: onCreateView")

        return inflater.inflate(R.layout.fragment_recipe_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("Category fragment: onViewCreated")
        recyclerView = recycler_view_recipe_list
        initRecyclerView(RecipeCategoryRecyclerAdapter(this@RecipeCategoryFragment))
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("Category fragment: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("Category fragment: onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("Category fragment: onActivityCreated")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("Category fragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("Category fragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("Category fragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("Category fragment: onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("Category fragment: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("Category fragment: onDetach")

    }


    override fun onCategoryClick(category: String) {
        val listener = activity
        if (listener is OnCategoriesListener.OnCategoryListener) {
            listener.onCategoryClick(category)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RecipeCategoryFragment()
    }
}