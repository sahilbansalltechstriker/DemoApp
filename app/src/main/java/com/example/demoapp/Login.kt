package com.example.demoapp


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.demoapp.databinding.LoginBinding
import com.example.demoapp.global.Constant
import com.example.demoapp.viewModels.LoginViewModel


class Login: BaseActivity<LoginBinding>() {


    lateinit var binding : LoginBinding
    lateinit var viewModel : LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //get reference from baseclass
        binding = (dataBinding as LoginBinding)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        binding.viewModel = viewModel
        //set activity reference for sending the context
        viewModel.attach(this)

    }


    //set layout
    override fun setLayout(): Int {
        return R.layout.login
    }

    //set toolbar title and back button
    override fun setSupportToolbar() {
        setToolBarWithTitle(false,Constant.LOGIN)
    }
}


