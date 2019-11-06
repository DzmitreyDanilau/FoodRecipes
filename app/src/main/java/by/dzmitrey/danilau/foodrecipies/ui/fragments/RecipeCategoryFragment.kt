package by.dzmitrey.danilau.foodrecipies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.adapters.OnRecipeListener
import by.dzmitrey.danilau.foodrecipies.adapters.RecipeRecyclerAdapter
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.util.VerticalItemDecorator
import by.dzmitrey.danilau.foodrecipies.viewmodels.RecipeListViewModel
import by.dzmitrey.danilau.foodrecipies.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_recipe_list.*
import timber.log.Timber
import javax.inject.Inject

class RecipeCategoryFragment : BaseFragment(), OnRecipeListener {
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    lateinit var recipeListViewModel: RecipeListViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var recipeListAdapter: RecipeRecyclerAdapter
       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = recycler_view_recipe_list
        recipeListViewModel = ViewModelProvider(this, providerFactory)
            .get(RecipeListViewModel::class.java)
        Timber.d("RecipeList viewModel: ${recipeListViewModel.hashCode()}")
        Timber.d("ProviderFactory Entity: $providerFactory")
        initRecyclerView()
//        initSearchView()
        subscribeObservers()
        if (!recipeListViewModel.isViewRecipes()) {
            displaySearchCategories()
        }
    }

    private fun subscribeObservers() {
        recipeListViewModel.getRecipesList().observe(viewLifecycleOwner,
            Observer<List<RecipeLocal>> {
                it?.let {
                    Timber.d("List of recipes: $it")
                    recipeListAdapter.setRecipes(it)
                }
            })
        recipeListViewModel.getRecipesListError().observe(viewLifecycleOwner,
            Observer<String> {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            })
    }

    private fun initRecyclerView() {
        recipeListAdapter = RecipeRecyclerAdapter(this@RecipeCategoryFragment)
        recyclerView.addItemDecoration(VerticalItemDecorator(30))
        recyclerView.adapter = recipeListAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

//    private fun initSearchView() {
//        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                query?.let {
//                    recipeListAdapter.displayLoading()
//                    recipeListViewModel.searchRecipes(it, 1)
//                }
//                return false
//            }
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return false
//            }
//        })
//    }

    private fun displaySearchCategories() {
        recipeListViewModel.setIsViewRecipes(false)
        recipeListAdapter.displaySearchCategories()
    }

    override fun onRecipeClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCategoryClick(category: String) {
        recipeListAdapter.displayLoading()
        recipeListViewModel.searchRecipes(category, 1)
    }

    companion object {
        @JvmStatic
        fun newInstance() = RecipeCategoryFragment()
    }
}
