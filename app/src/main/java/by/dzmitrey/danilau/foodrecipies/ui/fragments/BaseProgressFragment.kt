package by.dzmitrey.danilau.foodrecipies.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseProgressFragment : DaggerFragment() {
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressBar = progress_bar
    }

    fun showProgress(){
        progressBar.visibility = View.VISIBLE
    }
    fun hideProgress(){
        progressBar.visibility = View.GONE
    }
}