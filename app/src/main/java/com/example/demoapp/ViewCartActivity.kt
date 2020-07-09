package com.example.demoapp

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapp.databinding.DailymenuBinding
import com.example.demoapp.databinding.ViewCartBinding
import com.example.demoapp.global.Constant
import com.example.demoapp.models.Nearby_restaurants
import com.example.demoapp.models.ViewCartModel
import com.example.demoapp.viewModels.DailyMenuViewModel
import com.example.demoapp.viewModels.ViewCartViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import net.gahfy.mvvmposts.injection.BaseViewModelFactory

class ViewCartActivity: BaseActivity<ViewCartBinding>() {


     lateinit var binding : ViewCartBinding
    lateinit var viewModel : ViewCartViewModel


    override fun setSupportToolbar() {
        setToolBarWithTitle(true, Constant.VIEWCART)
    }

    override fun setLayout(): Int {
        return R.layout.view_cart
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //get reference from baseclass
        binding = (dataBinding as ViewCartBinding)
        var viewCartModel = intent.getSerializableExtra(Constant.OBJECT) as HashMap<Int,ViewCartModel>
        println(viewCartModel)

        viewModel = ViewModelProviders.of(this, BaseViewModelFactory { ViewCartViewModel()}).get(ViewCartViewModel::class.java)
        binding.viewModel = viewModel
        binding!!.rvViewCartList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel.bind(this)
        viewModel.updateCartAdapter(viewCartModel)


    }

}