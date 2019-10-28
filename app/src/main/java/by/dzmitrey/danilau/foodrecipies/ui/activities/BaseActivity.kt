package by.dzmitrey.danilau.foodrecipies.ui.activities

import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.adapters.OnRecipeListener
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_base.view.*

abstract class BaseActivity : DaggerAppCompatActivity(), OnRecipeListener {
    override fun setContentView(layoutResID: Int) {
        val constraintLayout = layoutInflater.inflate(R.layout.activity_base, null)
        val frameLayout = constraintLayout.activity_content
        layoutInflater.inflate(layoutResID, frameLayout, true)
        super.setContentView(layoutResID)
    }

    override fun onRecipeClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCategoryClick(category: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}