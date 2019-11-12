package by.dzmitrey.danilau.foodrecipies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.adapters.OnCategoryListener
import by.dzmitrey.danilau.foodrecipies.adapters.OnRecipeListener
import dagger.android.support.DaggerFragment

private const val ARG_PARAM1 = "category"

abstract class BaseFragment : DaggerFragment(), OnCategoryListener, OnRecipeListener {
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

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
}
