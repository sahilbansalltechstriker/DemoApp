package com.example.demoapp.serviceHandlers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demoapp.viewModels.BaseViewModel
import com.example.demoapp.viewModels.DailyMenuItemViewModel
import com.example.demoapp.viewModels.RestaurantDetailViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BaseViewModels(repository) as T
    }

}