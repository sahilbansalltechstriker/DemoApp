package com.example.demoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.demoapp.databinding.ForgotPasswordBinding
import com.example.demoapp.databinding.RegisterBinding
import com.example.demoapp.global.Constant
import com.example.demoapp.viewModels.ForgotPasswordViewModel
import com.example.demoapp.viewModels.RegisterViewModel
import kotlinx.android.synthetic.main.toolbar.*

class RegisterActivity:BaseActivity<RegisterBinding>() {
    lateinit var binding : RegisterBinding
    lateinit var viewModel : RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //get reference from baseclass
        binding = (dataBinding as RegisterBinding)
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)

        binding.viewModel = viewModel
        //set activity reference for sending the context
        viewModel.attach(this)
    }

    override fun setSupportToolbar() {
        setToolBarWithTitle(true,Constant.REGISTER)
    }

    override fun setLayout(): Int {
      return R.layout.register
    }
}