package com.example.demoapp.viewModels

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.demoapp.models.ViewCartModel

class CartViewItemModel: ViewModel() {
    lateinit var viewCartModel : ViewCartModel
    fun bind(viewCartModel: ViewCartModel?) {

        this.viewCartModel = viewCartModel!!

    }


    fun btnMinusViewCartHandler(view: View){

    }

    fun btnPlusViewCartHandler(view: View){

    }


}