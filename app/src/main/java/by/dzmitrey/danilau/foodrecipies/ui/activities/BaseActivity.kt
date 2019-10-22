package by.dzmitrey.danilau.foodrecipies.ui.activities

import android.view.View
import android.widget.ProgressBar
import by.dzmitrey.danilau.foodrecipies.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_base.view.*

abstract class BaseActivity : DaggerAppCompatActivity() {
    lateinit var progressBar: ProgressBar
    override fun setContentView(layoutResID: Int) {
        val constraintLayout = layoutInflater.inflate(R.layout.activity_base, null)
        val frameLayout = constraintLayout.activity_content
        progressBar = constraintLayout.progress_bar
        layoutInflater.inflate(layoutResID, frameLayout, true)
        super.setContentView(layoutResID)
    }

    fun showProgressBar(visibility: Boolean) {
        progressBar.visibility = if (visibility) View.VISIBLE else View.GONE
    }
}