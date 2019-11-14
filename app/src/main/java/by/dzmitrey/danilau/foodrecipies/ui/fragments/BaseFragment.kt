package by.dzmitrey.danilau.foodrecipies.ui.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.adapters.*
import by.dzmitrey.danilau.foodrecipies.util.VerticalItemDecorator
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment(),  OnRecipeListener, OnCategoryListener {
    protected var param1: String? = null
    lateinit var recyclerView: RecyclerView
    lateinit var recipeListAdapter: IRecyclerViewAdapter

    override fun onRecipeClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSubCategoryClick(subCategory: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCategoryClick(category: String) {
        val listener = activity
        if (listener is OnCategoryListener) {
            listener.onCategoryClick(category)
        }
    }

    protected fun initRecyclerView(adapter: IRecyclerViewAdapter) {
        when (adapter) {
            is RecipeCategoryRecyclerAdapter -> {
                recipeListAdapter = RecipeCategoryRecyclerAdapter(this)
                recyclerView.adapter = recipeListAdapter as RecipeCategoryRecyclerAdapter
            }
            is RecipeListRecyclerAdapter -> {
                recipeListAdapter = RecipeListRecyclerAdapter(this)
                recyclerView.adapter = recipeListAdapter as RecipeListRecyclerAdapter
            }
        }
        recyclerView.addItemDecoration(VerticalItemDecorator(30))
        recyclerView.layoutManager = LinearLayoutManager(context)
    }


}
