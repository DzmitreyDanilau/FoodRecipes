package by.dzmitrey.danilau.foodrecipies.ui.activities

import android.os.Bundle
import by.dzmitrey.danilau.foodrecipies.R
import by.dzmitrey.danilau.foodrecipies.ui.fragments.RecipeCategoryFragment

class RecipeListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_content, RecipeCategoryFragment.newInstance()).commit()
    }

}
