package by.dzmitrey.danilau.foodrecipies.adapters.delegates

import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView

class AdapterDelegatesManager<T> {

    val delegates = SparseArrayCompat<AdapterDelegate<T>>()

//    fun addDelegate(delegate: AdapterDelegate<T>): AdapterDelegatesManager<T>{
//        var viewType = delegates.size()
//
//    }
//    fun getItemViewType(items: T, position: Int){
//
//    }
//    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
//
//    }
    fun onBindViewHolder(items: T, position: Int, holder: RecyclerView.ViewHolder){

    }
}