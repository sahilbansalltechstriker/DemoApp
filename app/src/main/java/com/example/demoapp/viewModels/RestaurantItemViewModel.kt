package com.example.demoapp.viewModels

import androidx.lifecycle.MutableLiveData
import com.example.demoapp.databinding.RestaurantItemsBinding
import com.example.demoapp.models.Nearby_restaurants


class RestaurantItemViewModel:BaseViewModel() {

     var nearbyRestaurants = MutableLiveData<Nearby_restaurants>()
    lateinit var binding: RestaurantItemsBinding
    fun bind(
        restaurantModel: Nearby_restaurants ){
        this.nearbyRestaurants.value = restaurantModel
    }
}