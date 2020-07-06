package com.example.demoapp.viewModels

import android.app.Activity
import com.example.demoapp.RestaurantDetail
import com.example.demoapp.models.Nearby_restaurants

class RestaurantDetailViewModel : BaseViewModel(){
    lateinit var activity: Activity
    lateinit var nearbyRestaurant: Nearby_restaurants
    fun attach(activity: Activity) {
        this.activity = activity
    }

    fun updateMethod(nearbyRestaurant: Nearby_restaurants) {

        this.nearbyRestaurant = nearbyRestaurant
    }

}