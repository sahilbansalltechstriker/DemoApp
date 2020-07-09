package com.example.demoapp.viewModels

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.demoapp.ForgotPassword
import com.example.demoapp.MainActivity
import com.example.demoapp.RegisterActivity
import com.example.demoapp.global.toast

class LoginViewModel  :ViewModel(){
    lateinit var activity: Activity
     var email : String = "12"
     var password : String = "12"

    //set activity reference for sending the context
    fun attach(activity: Activity) {
        this.activity = activity
    }

    //for open the forgot password screen
    fun forgotPasswordListener(view: View){
       var intent = Intent(activity, ForgotPassword::class.java)
        activity.startActivity(intent)
    }

    //for open the signUp password screen
    fun signUpListener(view: View){
        var intent = Intent(activity, RegisterActivity::class.java)
        activity.startActivity(intent)
    }

    //check the login credentials
    fun loginListener(view: View){
       if(isValidate()){

           var intent = Intent(activity, MainActivity::class.java)
           activity.startActivity(intent)
       }
    }

    private fun isValidate(): Boolean {
        if(email.isNullOrEmpty()){
            activity.toast("please enter the email")
            return false
        }

        if(password.isNullOrEmpty()){
            activity.toast("please enter the password")
            return false
        }
        return true
    }


}