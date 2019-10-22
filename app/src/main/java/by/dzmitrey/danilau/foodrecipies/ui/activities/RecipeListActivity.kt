package by.dzmitrey.danilau.foodrecipies.ui.activities

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.models.app.RecipeLocal
import by.dzmitrey.danilau.foodrecipies.models.backend.RecipeApi
import by.dzmitrey.danilau.foodrecipies.viewmodels.RecipeListViewModel
import by.dzmitrey.danilau.foodrecipies.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_recipe_list.*
import timber.log.Timber
import javax.inject.Inject

class RecipeListActivity : BaseActivity() {
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    lateinit var recipeListViewModel: RecipeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipeListViewModel = ViewModelProvider(this, providerFactory)
            .get(RecipeListViewModel::class.java)
        setContentView(R.layout.activity_recipe_list)
        Timber.d("ProviderFactory Entity: $providerFactory")
        recipeListViewModel.searchRecipes("chicken", 1)
        recipeListViewModel.getRecipesList().observe(this, Observer<List<RecipeLocal>> { it ->
            var test: String? = null
            it.forEach {
                test += it.title
                Timber.d("Inside foreach $test")
            }
            tv_recipeList.text = test
        })
        recipeListViewModel.getRecipesListError().observe(this, Observer<String> {
            tv_recipeList.text = it
        })
    }
}
