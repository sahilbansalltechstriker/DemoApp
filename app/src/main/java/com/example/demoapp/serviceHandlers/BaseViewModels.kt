package com.example.demoapp.serviceHandlers

import androidx.lifecycle.ViewModel
import com.example.demoapp.serviceHandler.DaggerViewModelInjector
import com.example.demoapp.serviceHandler.NetworkModule
import com.example.demoapp.serviceHandler.ViewModelInjector
import com.example.demoapp.viewModels.RestaurantItemViewModel
import com.example.demoapp.viewModels.RestaurantListViewModel

open class BaseViewModels(private val repository: Repository): ViewModel(){



}