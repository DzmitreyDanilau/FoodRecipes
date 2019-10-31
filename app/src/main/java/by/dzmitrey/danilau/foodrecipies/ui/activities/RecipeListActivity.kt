package by.dzmitrey.danilau.foodrecipies.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.adapters.RecipeRecyclerAdapter
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.viewmodels.RecipeListViewModel
import by.dzmitrey.danilau.foodrecipies.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_recipe_list.*
import timber.log.Timber
import javax.inject.Inject

class RecipeListActivity : BaseActivity() {
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    lateinit var recipeListViewModel: RecipeListViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var recipeListAdapter: RecipeRecyclerAdapter
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)
        progressBar = progress_bar
        recyclerView = recycler_view_recipe_list
        recipeListViewModel = ViewModelProvider(this, providerFactory)
            .get(RecipeListViewModel::class.java)
        Timber.d("RecipeList viewModel: ${recipeListViewModel.hashCode()}")
        Timber.d("ProviderFactory Entity: $providerFactory")
        initRecyclerView()
        initSearchView()
        subscribeObservers()

    }


    private fun subscribeObservers() {
        recipeListViewModel.getRecipesList().observe(this@RecipeListActivity,
            Observer<List<RecipeLocal>> {
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

    private fun initSearchView() {
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener  {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    recipeListAdapter.displayLoading()
                    recipeListViewModel.searchRecipes(it, 1)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

    }

    fun showProgressBar(visibility: Boolean) {
        progressBar.visibility = if (visibility) View.VISIBLE else View.GONE
    }
}
