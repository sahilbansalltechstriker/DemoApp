package com.example.demoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.R
import com.example.demoapp.databinding.RestaurantItemsBinding
import com.example.demoapp.models.Nearby_restaurants
import com.example.demoapp.viewModels.RestaurantItemViewModel

class RestaurantListAdapter : RecyclerView.Adapter<RestaurantListAdapter.ViewHolder>() {
     lateinit var restaurantList:List<Nearby_restaurants>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListAdapter.ViewHolder {
        val binding: RestaurantItemsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.restaurant_items, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(restaurantList[position])
    }

    override fun getItemCount(): Int {
        return if(::restaurantList.isInitialized) restaurantList.size else 0
    }

    fun updatePostList(restaurantList:List<Nearby_restaurants>){
        this.restaurantList = restaurantList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: RestaurantItemsBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = RestaurantItemViewModel()

        fun bind(post:Nearby_restaurants){

            binding.viewModel = viewModel
            viewModel.bind(post)
        }
    }
}