package by.dzmitrey.danilau.foodrecipies.ui.activities

import android.os.Bundle
import by.dzmitrey.danilau.foodrecipies.R
import kotlinx.android.synthetic.main.activity_base.*

class RecipeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        toolbar = findViewById(R.id.tool_bar)
        setSupportActionBar(toolbar)
        toolbarTitle = tool_bar_title
        init()
    }
}
