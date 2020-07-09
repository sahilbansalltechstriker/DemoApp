package com.example.demoapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.demoapp.ViewCartActivity
import com.example.demoapp.adapters.ViewCartAdapter
import com.example.demoapp.models.ViewCartModel

class ViewCartViewModel :ViewModel(){

    var viewCartAdapter : ViewCartAdapter = ViewCartAdapter()

   lateinit var viewCartActivity: ViewCartActivity
    var viewCartModelList: HashMap<Int,ViewCartModel>? = null
    fun bind(viewCartActivity: ViewCartActivity) {
        this.viewCartActivity = viewCartActivity
    }







     fun updateCartAdapter(viewCartModelList: HashMap<Int,ViewCartModel>) {

        this.viewCartModelList = viewCartModelList
        viewCartAdapter.updateCartList(viewCartModelList!!)

    }

}