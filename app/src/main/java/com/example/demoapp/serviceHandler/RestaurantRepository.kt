package com.example.demoapp.serviceHandler

import androidx.lifecycle.MutableLiveData
import com.example.demoapp.models.Nearby_restaurants

import com.example.demoapp.models.RestaurantModel
import com.example.demoapp.serviceHandlers.RetrofitClient
import com.example.demoapp.viewModels.RestaurantListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RestaurantRepository {
     var restaurantList: ArrayList<Nearby_restaurants> = ArrayList()
    private val mutableLiveData: MutableLiveData<List<Nearby_restaurants>> =
        MutableLiveData<List<Nearby_restaurants>>()

    fun getRestaurantList(restaurantListViewModel: RestaurantListViewModel): MutableLiveData<List<Nearby_restaurants>> {

        val call = RetrofitClient.service.getAllRestaurants()
        call.enqueue(object : Callback<RestaurantModel?> {
            override fun onResponse(
                call: Call<RestaurantModel?>,
                response: Response<RestaurantModel?>
            ) {
                val employeeDBResponse: RestaurantModel? = response.body()
                if (employeeDBResponse != null && employeeDBResponse.nearbyRestaurants != null) {
                    restaurantList = employeeDBResponse.nearbyRestaurants as java.util.ArrayList<Nearby_restaurants>
                    mutableLiveData.value = restaurantList
                    restaurantListViewModel.onRetrievePostListSuccess(restaurantList)
                }
            }

            override fun onFailure(
                call: Call<RestaurantModel?>,
                t: Throwable
            ) {
                restaurantListViewModel.onRetrievePostListError()
                println(t.message)
            }
        })

        return mutableLiveData
    }

    companion object {
        private const val TAG = "EmployeeRepository"
    }
}