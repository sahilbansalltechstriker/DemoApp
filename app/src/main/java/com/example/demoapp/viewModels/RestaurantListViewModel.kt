package com.example.demoapp.viewModels

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.demoapp.R
import com.example.demoapp.adapters.RestaurantListAdapter
import com.example.demoapp.models.Nearby_restaurants
import com.example.demoapp.serviceHandler.MyApi
import com.example.demoapp.serviceHandler.RestaurantRepository
import javax.inject.Inject


class RestaurantListViewModel ():BaseViewModel(){
    @Inject
    lateinit var postApi: MyApi
    val restaurantListAdapter: RestaurantListAdapter = RestaurantListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadRestaurants() }
    init{
        loadRestaurants()
    }

    private fun loadRestaurants(){
        onRetrievePostListStart()
        RestaurantRepository().getRestaurantList(this)
    }

    private  fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

     private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

     fun onRetrievePostListSuccess(postList: List<Nearby_restaurants>){
        restaurantListAdapter.updatePostList(postList)
        onRetrievePostListFinish()
    }

     fun onRetrievePostListError(){
        errorMessage.value = R.string.post_error
    }
}