package com.example.demoapp.viewModels

import android.widget.ImageView
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.demoapp.R
import com.example.demoapp.databinding.RestaurantItemsBinding
import com.example.demoapp.models.Nearby_restaurants


class RestaurantItemViewModel:BaseViewModel() {
    private val name = MutableLiveData<String>()
    private val featureImage = MutableLiveData<String>()
     var averageCost : Int = 0
    private val location = MutableLiveData<String>()
     lateinit var rating : String
    lateinit var binding: RestaurantItemsBinding
    fun bind(
        restaurantModel: Nearby_restaurants,
        binding: RestaurantItemsBinding
    ){
        name.value =  restaurantModel.restaurant?.name
        featureImage.value =  restaurantModel.restaurant?.featured_image
        averageCost = restaurantModel.restaurant?.average_cost_for_two!!
        location.value = restaurantModel.restaurant?.location?.address!!
        rating = restaurantModel.restaurant?.user_rating?.aggregate_rating.toString()!!
        this.binding = binding
        loadImage(binding.ivRestaurantImage,restaurantModel.restaurant?.featured_image)
        getRating()
        getAverageCost()
    }

    fun getName():MutableLiveData<String>{
        return name
    }

    fun getAverageCost() {
        binding.tvPersons.text ="Average Cost for two : $averageCost"
    }
    fun getAddress():MutableLiveData<String>{
        return location
    }





    fun getRating() {
        val rate: Float = rating.toFloat()

         binding.rating.rating = rate
    }





    var resultImageUrl = ObservableField<String>()
    fun getFeatureImage(url: String?) {

        resultImageUrl.set(url)
    }


    fun loadImage(imageView: ImageView, imageURL: String?) {
        Glide.with(imageView.context)
            .setDefaultRequestOptions(
                RequestOptions()
            )
            .load(imageURL)
            .placeholder(R.drawable.ic_dummy_restautant)
            .into(imageView)
    }

}