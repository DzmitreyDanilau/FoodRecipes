package by.dzmitrey.danilau.foodrecipies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.adapters.OnRecipeListener
import by.dzmitrey.danilau.foodrecipies.adapters.RecipeListRecyclerViewAdapter
import by.dzmitrey.danilau.foodrecipies.ui.activities.IRecipeActivity
import by.dzmitrey.danilau.foodrecipies.viewmodels.RecipeListViewModel
import by.dzmitrey.danilau.foodrecipies.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.fragment_recipe_category.*
import kotlinx.android.synthetic.main.fragment_recipe_category.recycler_view_recipe_list
import kotlinx.android.synthetic.main.fragment_recipe_list.*
import timber.log.Timber
import javax.inject.Inject


class RecipesListFragment : BaseProgressFragment() {
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    lateinit var recipeListViewModel: RecipeListViewModel
    var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(getString(R.string.intent_message))
            Timber.d("From bundle: $param1")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recipeListViewModel = ViewModelProvider(this@RecipesListFragment, providerFactory)
            .get(RecipeListViewModel::class.java)
        recipeListViewModel.searchRecipes(param1!!, 1)
        return inflater.inflate(R.layout.fragment_recipe_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = progress_bar
        recyclerView = recycler_view_recipe_list
        initRecyclerView(RecipeListRecyclerViewAdapter(this))
        observeProgress()
    }


    private fun subscribeObserver() {
        recipeListViewModel.getRecipesList().observe(viewLifecycleOwner,
            Observer {
                it?.also {
                    recipeListAdapter.setItems(it)
                }
                recipeListViewModel.getRecipesListError().observe(viewLifecycleOwner,
                    Observer { errorMessage ->
                        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                    })
            })
    }

    private fun observeProgress() {
        recipeListViewModel.getProgressState().observe(viewLifecycleOwner,
            Observer<Boolean> {
                if (it) {
                    showProgress()
                    recipeListViewModel.getRecipesList().observe(viewLifecycleOwner, Observer {
                        recipeListAdapter.setItems(it)
                    })
                } else {
                    hideProgress()
                }
            }
        )
    }
    fun showProgress() {
        progressBar?.visibility = View.VISIBLE
    }

    fun hideProgress() {
        progressBar?.visibility = View.GONE
    }

    companion object {
        @JvmStatic
        fun newInstance() = RecipesListFragment()
    }
}
