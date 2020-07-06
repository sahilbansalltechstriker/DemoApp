package com.example.demoapp.viewModels



import android.app.Activity
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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




 /*  companion object{
       @JvmStatic @BindingAdapter("bind:imageUrl")
       fun loadImage(imageView: ImageView, url: String?) {
           Glide.with(imageView.context)
               .setDefaultRequestOptions(
                   RequestOptions()
               )
               .load(url)
               .placeholder(com.example.demoapp.R.drawable.ic_dummy_restautant)
               .into(imageView)
       }
   }*/
}