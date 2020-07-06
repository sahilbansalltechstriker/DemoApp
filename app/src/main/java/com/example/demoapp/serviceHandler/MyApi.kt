package com.example.demoapp.serviceHandler

import com.example.demoapp.models.RestaurantModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * The interface which provides methods to get result of webservices
 */
interface MyApi {
    /**
     * Get the list of the pots from the API
     */
    @Headers(
        "user-key: 3aa6f742adb2e30871ffb22f04eae8ce"
    )
    @GET("geocode?lat=30.7046&lon=76.7179")
    fun getAllRestaurants(): Call<RestaurantModel>



}

