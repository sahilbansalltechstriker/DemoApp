package com.example.demoapp

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.demoapp.databinding.ForgotPasswordBinding
import com.example.demoapp.global.Constant
import com.example.demoapp.viewModels.ForgotPasswordViewModel
class ForgotPassword : BaseActivity<ForgotPasswordBinding>(){
    lateinit var binding : ForgotPasswordBinding
    lateinit var viewModel : ForgotPasswordViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //get reference from baseclass
        binding = (dataBinding as ForgotPasswordBinding)
        viewModel = ViewModelProviders.of(this).get(ForgotPasswordViewModel::class.java)

        binding.viewModel = viewModel
        //set activity reference for sending the context
        viewModel.attach(this)
    }

    override fun setSupportToolbar() {
        setToolBarWithTitle(true,Constant.FORGOT_PASSWORD)
    }

    override fun setLayout(): Int {
        return R.layout.forgot_password
    }
}