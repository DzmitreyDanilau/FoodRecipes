package by.dzmitrey.danilau.foodrecipies.ui.activities

import by.dzmitrey.danilau.foodrecipies.ui.fragments.BaseFragment

interface IRecipeActivity {
    fun setToolBarTitle(fragmentTag: String)
    fun inflateFragment(fragmentTag: String, param: String)
    fun doFragmentTransaction(
        fragment: BaseFragment,
        tag: String,
        addToBackStack: Boolean,
        message: String?
    )
}