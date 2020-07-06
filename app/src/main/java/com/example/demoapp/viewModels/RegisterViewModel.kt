package com.example.demoapp.viewModels

import android.app.Activity
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.demoapp.global.toast

class RegisterViewModel :ViewModel(){
    lateinit var activity: Activity
    var username : String = ""
    var email : String = ""
    var mobileNumber : String = ""
    var password : String = ""
    var confirmPassword : String = ""

    //
    fun btnRegisterListener(view: View){
        //check all fields validations
        if(validate()){
            activity.toast("Success")
        }
    }

    private fun validate(): Boolean {
        if(username.isNullOrEmpty()){
            activity.toast("please enter the Username")
            return false
        }
        if(email.isNullOrEmpty()){
            activity.toast("please enter the Email")
            return false
        }
        if(mobileNumber.isNullOrEmpty()){
            activity.toast("please enter the Mobile Number")
            return false
        }
        if(password.isNullOrEmpty()){
            activity.toast("please enter the Password")
            return false
        }

        if(confirmPassword.isNullOrEmpty()){
            activity.toast("please enter the Confirm Password")
            return false
        }

        if(password != confirmPassword){
            activity.toast("Confirm Password are not same")
            return false
        }
        return true
    }
    //back to login page
    fun loginListener(view: View){
        activity?.finish()
    }

    fun attach(activity: Activity) {

        this.activity = activity;
    }

}