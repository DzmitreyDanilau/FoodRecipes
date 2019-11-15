package by.dzmitrey.danilau.foodrecipies.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.adapters.*
import by.dzmitrey.danilau.foodrecipies.util.VerticalItemDecorator
import dagger.android.support.DaggerFragment
import timber.log.Timber

abstract class BaseFragment : DaggerFragment(), OnRecipeListener, OnCategoryListener {
    protected var param1: String? = null
    lateinit var category: String
    lateinit var recyclerView: RecyclerView
    lateinit var recipeAdapter: IRecyclerViewAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("fragment: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("fragment: onCreate")
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

    override fun onRecipeClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSubCategoryClick(subCategory: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCategoryClick(category: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    protected fun initRecyclerView(adapter: IRecyclerViewAdapter) {
        when (adapter) {
            is RecipeCategoryRecyclerAdapter -> {
                recipeAdapter = adapter
                recyclerView.adapter = recipeAdapter as RecipeCategoryRecyclerAdapter
            }
            is RecipeSubCategoryRecyclerAdapter -> {
                recipeAdapter = adapter
                recyclerView.adapter = recipeAdapter as RecipeSubCategoryRecyclerAdapter
            }
            is RecipeListRecyclerAdapter -> {
                recipeAdapter = adapter
                recyclerView.adapter = recipeAdapter as RecipeListRecyclerAdapter
            }

        }
        recyclerView.addItemDecoration(VerticalItemDecorator(30))
        recyclerView.layoutManager = LinearLayoutManager(context)
    }
}
