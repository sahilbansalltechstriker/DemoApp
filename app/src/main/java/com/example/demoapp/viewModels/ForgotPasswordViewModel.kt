package com.example.demoapp.viewModels

import android.app.Activity
import android.view.View
import androidx.lifecycle.ViewModel

class ForgotPasswordViewModel :ViewModel(){
     var activity: Activity? = null
    var email : String = ""


    //send forgot password
    fun btnSendForgotPasswordListener(view: View){

    }

    //back to login page
    fun loginListener(view: View){
        activity?.finish()
    }

    fun attach(activity: Activity) {
        this.activity = activity

    }
}