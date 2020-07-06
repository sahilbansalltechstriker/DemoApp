package com.example.demoapp.viewModels


import androidx.lifecycle.ViewModel
import com.example.demoapp.serviceHandler.DaggerViewModelInjector
import com.example.demoapp.serviceHandler.NetworkModule
import com.example.demoapp.serviceHandler.ViewModelInjector

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is RestaurantListViewModel -> injector.inject(this)
            is RestaurantItemViewModel -> injector.inject(this)
        }
    }
}