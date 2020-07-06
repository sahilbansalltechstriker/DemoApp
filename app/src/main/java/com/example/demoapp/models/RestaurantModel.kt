package com.example.demoapp.models

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.demoapp.R
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

class RestaurantModel {
    @SerializedName("nearby_restaurants")
    @Expose
    var nearbyRestaurants: List<Nearby_restaurants>? = null
}
@Parcelize
data class Nearby_restaurants (

    val restaurant : Restaurant?
):Parcelable
@Parcelize
data class Restaurant(val apikey : String,
                      val id : Int,
                      val name : String,
                      val url : String,
                      val location : Location,
                      val switch_to_order_menu : Int,
                      val cuisines : String,
                      val average_cost_for_two : Int,
                      val price_range : Int,
                      val currency : String,
                      val offers : List<String>,
                      val opentable_support : Int,
                      val is_zomato_book_res : Int,
                      val mezzo_provider : String,
                      val is_book_form_web_view : Int,
                      val book_form_web_view_url : String,
                      val book_again_url : String,
                      val thumb : String,
                      val user_rating : User_rating,
                      val photos_url : String,
                      val menu_url : String,
                      val featured_image : String,
                      val has_online_delivery : Int,
                      val is_delivering_now : Int,
                      val store_type : String,
                      val include_bogo_offers : Boolean,
                      val deeplink : String,
                      val order_url : String?,
                      val order_deeplink : String,
                      val is_table_reservation_supported : Int,
                      val has_table_booking : Int,
                      val events_url : String
): Parcelable

@Parcelize
data class User_rating (

    val aggregate_rating : Float,
    val rating_text : String,
    val rating_color : String,
    val votes : Int
): Parcelable

@Parcelize
data class Location (
    val address : String,
    val locality : String,
    val city : String,
    val city_id : Int,
    val latitude : Double,
    val longitude : Double,
    val zipcode : String,
    val country_id : Int,
    val locality_verbose : String
): Parcelable