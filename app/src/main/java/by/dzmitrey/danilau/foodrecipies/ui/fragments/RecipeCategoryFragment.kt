package by.dzmitrey.danilau.foodrecipies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.adapters.RecipeCategoryRecyclerAdapter
import by.dzmitrey.danilau.foodrecipies.util.VerticalItemDecorator
import kotlinx.android.synthetic.main.fragment_recipe_category.*

class RecipeCategoryFragment : BaseFragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var recipeListAdapter: RecipeCategoryRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = recycler_view_recipe_list
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recipeListAdapter = RecipeCategoryRecyclerAdapter(this@RecipeCategoryFragment)
        recyclerView.addItemDecoration(VerticalItemDecorator(30))
        recyclerView.adapter = recipeListAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    companion object {
        @JvmStatic
        fun newInstance() = RecipeCategoryFragment()
    }
}
