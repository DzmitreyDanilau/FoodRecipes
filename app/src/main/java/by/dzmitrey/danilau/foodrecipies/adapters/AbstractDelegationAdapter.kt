package by.dzmitrey.danilau.foodrecipies.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractDelegationAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    internal var delegatesmanager: AdapterDelegatesManager<T> = AdapterDelegatesManager()
    internal var items = mutableListOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
}