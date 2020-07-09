package com.example.demoapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DailyMenuModel(val id: Int= 0,var name: String= "",var description : String= "", var res_id: String= "",
                          var rate : Float = 0f,var discount : Float= 0f,var rating : Float= 0f ,var reviewCount : Int = 0,var image: String= "",
                            var totalQuantity :Int = 0,var selectedQuantity: Int = 0):Parcelable{constructor() : this(0,"",
    "","",0f,0f,0f,0,"",0,0) }


