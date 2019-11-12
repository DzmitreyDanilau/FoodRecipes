package by.dzmitrey.danilau.foodrecipies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.adapters.*
import by.dzmitrey.danilau.foodrecipies.util.VerticalItemDecorator
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment(), OnCategoryListener, OnRecipeListener {
    protected var param1: String? = null
    lateinit var recyclerView: RecyclerView
    lateinit var recipeListAdapter: IRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }


    override fun onCategoryClick(category: String) {
        val listener = activity
        if (listener is OnCategoryListener) {
            listener.onCategoryClick(category)
        }
    }

    override fun onRecipeClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    protected fun initRecyclerView(adapter: IRecyclerViewAdapter) {
        when (adapter) {
            is RecipeCategoryRecyclerAdapter -> {
                recipeListAdapter = RecipeCategoryRecyclerAdapter(this)
                recyclerView.adapter = recipeListAdapter as RecipeCategoryRecyclerAdapter
            }
            is RecipeListRecyclerViewAdapter -> {
                recipeListAdapter = RecipeListRecyclerViewAdapter(this)
                recyclerView.adapter = recipeListAdapter as RecipeListRecyclerViewAdapter
            }
        }
        recyclerView.addItemDecoration(VerticalItemDecorator(30))
        recyclerView.layoutManager = LinearLayoutManager(context)
    }


}
