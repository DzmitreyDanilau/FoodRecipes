package by.dzmitrey.danilau.foodrecipies.ui.activities

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.adapters.OnRecipeListener
import by.dzmitrey.danilau.foodrecipies.adapters.RecipeRecyclerAdapter
import by.dzmitrey.danilau.foodrecipies.models.backend.Recipe
import by.dzmitrey.danilau.foodrecipies.viewmodels.RecipeListViewModel
import by.dzmitrey.danilau.foodrecipies.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_recipe_list.*
import timber.log.Timber
import javax.inject.Inject

class RecipeListActivity : BaseActivity(), OnRecipeListener {
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    lateinit var recipeListViewModel: RecipeListViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var recipeListAdapter: RecipeRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)
        recyclerView = recycler_view
        recipeListViewModel = ViewModelProvider(this, providerFactory)
            .get(RecipeListViewModel::class.java)
        Timber.d("RecipeList viewModel: ${recipeListViewModel.hashCode()}")
        Timber.d("ProviderFactory Entity: $providerFactory")
        initRecyclerView()
        subscribeObservers()
        recipeListViewModel.searchRecipes("chicken", 1)
    }


    private fun subscribeObservers() {
        recipeListViewModel.getRecipesList().observe(this@RecipeListActivity,
            Observer<List<Recipe>> {
                it?.let {
                    Timber.d("List of recipes: $it")
                    recipeListAdapter.setRecipes(it)
                }

            })
        recipeListViewModel.getRecipesListError().observe(this@RecipeListActivity,
        Observer<String> {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun initRecyclerView() {
        recipeListAdapter = RecipeRecyclerAdapter(this@RecipeListActivity)
        recyclerView.adapter = recipeListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this@RecipeListActivity)
    }

    override fun onRecipeClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCategoryClick(category: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
