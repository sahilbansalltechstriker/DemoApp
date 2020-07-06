package com.example.demoapp

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.demoapp.databinding.RestaurantDetailBinding
import com.example.demoapp.global.Constant

import com.example.demoapp.models.Nearby_restaurants
import com.example.demoapp.viewModels.RestaurantDetailViewModel
import net.gahfy.mvvmposts.injection.BaseViewModelFactory


class RestaurantDetail :BaseActivity<RestaurantDetailBinding>() {
    lateinit var binding: RestaurantDetailBinding
    lateinit var viewModel: RestaurantDetailViewModel

    lateinit var nearbyRestaurant : Nearby_restaurants

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //get reference from baseclass
        binding = dataBinding as RestaurantDetailBinding

        viewModel = ViewModelProviders.of(this, BaseViewModelFactory {RestaurantDetailViewModel() }).get( RestaurantDetailViewModel::class.java)

        binding.viewModel = viewModel
        //set activity reference for sending the context
        viewModel.attach(this)

        nearbyRestaurant = intent.getParcelableExtra<Nearby_restaurants>(Constant.OBJECT) as Nearby_restaurants

        viewModel.updateMethod(nearbyRestaurant)

        setToolBarWithTitle(true, nearbyRestaurant.restaurant!!.name)

    }

    override fun setSupportToolbar() {

    }

    override fun setLayout(): Int {
        return R.layout.restaurant_detail
    }
}