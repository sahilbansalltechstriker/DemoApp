package com.example.demoapp

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlinx.android.synthetic.main.toolbar.*


abstract class BaseActivity<B : ViewDataBinding?>: AppCompatActivity() {
    protected var dataBinding: ViewDataBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, setLayout());


        setSupportToolbar()

    }

    //set toolbar navigation
    abstract fun setSupportToolbar()


    @LayoutRes
    abstract fun setLayout() : Int

    fun setToolBarWithTitle(backButton : Boolean, title : String){

        //set toolbar title
        toolbar?.title = title

        setSupportActionBar(toolbar)
        if(backButton){
            supportActionBar?.setDisplayShowHomeEnabled(true);
            supportActionBar?.setDisplayHomeAsUpEnabled(true);
        }

        toolbar?.setNavigationOnClickListener { onBackPressed() }
    }


}

