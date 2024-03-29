package by.dzmitrey.danilau.foodrecipies.ui.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.adapters.OnCategoriesListener
import by.dzmitrey.danilau.foodrecipies.adapters.OnRecipeListener
import by.dzmitrey.danilau.foodrecipies.ui.fragments.*
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_base.view.*

abstract class BaseActivity : DaggerAppCompatActivity(),
    OnRecipeListener,
    OnCategoriesListener.OnSubCategoryListener,
    IRecipeActivity,
    OnCategoriesListener.OnCategoryListener {
    lateinit var toolbar: Toolbar
    lateinit var toolbarTitle: TextView
    override fun setContentView(layoutResID: Int) {
        val linearLayout = layoutInflater.inflate(R.layout.activity_base, null)
        val frameLayout = linearLayout.activity_content
        layoutInflater.inflate(layoutResID, frameLayout, true)
        super.setContentView(layoutResID)
    }

    override fun onCategoryClick(category: String) {
        inflateFragment(getString(R.string.recipes_subcategory_fragment), category)
    }

    override fun onSubCategoryClick(subCategory: String) {
        inflateFragment(getString(R.string.recipes_list_fragment), subCategory)
    }

    override fun onRecipeClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setToolBarTitle(fragmentTag: String) {
        toolbarTitle.text = fragmentTag
    }

    override fun inflateFragment(fragmentTag: String, param: String) {
        when (fragmentTag) {
            getString(R.string.recipes_category_fragment) -> {
                val recipeCategoryFragment = RecipeCategoryFragment.newInstance()
                doFragmentTransaction(
                    recipeCategoryFragment,
                    getString(R.string.recipes_category_fragment),
                    false,
                    null
                )
            }

            getString(R.string.recipes_subcategory_fragment) -> {
                val recipeSubCategoryFragment = RecipeSubCategoryFragment.newInstance()
                doFragmentTransaction(
                    recipeSubCategoryFragment,
                    getString(R.string.recipes_subcategory_fragment),
                    true,
                    param
                )
            }

            getString(R.string.recipes_list_fragment) -> {
                val recipesListFragment = RecipesListFragment.newInstance()
                doFragmentTransaction(
                    recipesListFragment,
                    getString(R.string.recipes_list_fragment),
                    true,
                    param
                )
            }

            getString(R.string.recipes_details_fragment) -> {
                val recipeDetailsFragment = RecipeDetailsFragment.newInstance()
                doFragmentTransaction(
                    recipeDetailsFragment,
                    getString(R.string.recipes_details_fragment),
                    true,
                    param
                )
            }
        }
    }

    fun init() {
        val recipeCategoryFragment = RecipeCategoryFragment.newInstance()
        doFragmentTransaction(
            recipeCategoryFragment, getString(R.string.recipes_category_fragment), false, null
        )
    }

    override fun doFragmentTransaction(
        fragment: BaseFragment,
        tag: String,
        addToBackStack: Boolean,
        message: String?
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        message?.let {
            val bundle = Bundle()
            bundle.putString(getString(R.string.intent_message), it)
            fragment.arguments = bundle
        }
        transaction.replace(R.id.activity_content, fragment, tag)
        if (addToBackStack) {
            transaction.addToBackStack(tag)
        }
        transaction.commit()
    }

    override fun onBackPressed() {
        toolbarTitle.text = getString(R.string.recipes_category_fragment)
        super.onBackPressed()
    }
}