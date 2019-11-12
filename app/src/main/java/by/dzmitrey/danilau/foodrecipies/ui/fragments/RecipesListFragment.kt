package by.dzmitrey.danilau.foodrecipies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.dzmitrey.danilau.foodrecipies.R

class RecipesListFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_list, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = RecipesListFragment()
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
}
