package com.example.demoapp.viewModels

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.demoapp.DailyMenuActivity
import com.example.demoapp.adapters.DailyMenuAdapter
import com.example.demoapp.models.DailyMenuModel

class DailyMenuItemViewModel(): ViewModel(){

    var ocject = DailyMenuModel()
    lateinit var activity: DailyMenuActivity
    lateinit var dailyMenuAdapter: DailyMenuAdapter
    fun bind(
        dailyMenuModel: DailyMenuModel,
        activity:   DailyMenuActivity,
        dailyMenuAdapter: DailyMenuAdapter
    ){
        this.ocject= dailyMenuModel
        this.activity = activity
        this.dailyMenuAdapter = dailyMenuAdapter
    }
    fun btnMinusListener(view: View){

        if(ocject.selectedQuantity >0){
            ocject.selectedQuantity--


        }else{

            Toast.makeText(activity,"Only "+ocject.name+" is already on 0",Toast.LENGTH_LONG).show()
        }

        dailyMenuAdapter.notifyDataSetChanged()
        activity.priceCalculating()
        activity.viewCartVisibility()
    }

    fun btnPlusListener(view: View){

      if(ocject.totalQuantity>ocject.selectedQuantity){
          ocject.selectedQuantity++
          dailyMenuAdapter.notifyDataSetChanged()
          activity.priceCalculating()
      }else{
          Toast.makeText(activity,"Only "+ocject.totalQuantity+" "+ocject.name+" is available for now",Toast.LENGTH_LONG).show()
      }
        activity.viewCartVisibility()
    }



}