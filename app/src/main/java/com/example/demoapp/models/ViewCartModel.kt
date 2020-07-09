package com.example.demoapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ViewCartModel(var nearbyRestaurants: Nearby_restaurants,var dailyMenuModel: DailyMenuModel): Parcelable