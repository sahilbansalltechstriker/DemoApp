package com.example.demoapp.serviceHandler

import com.example.demoapp.viewModels.RestaurantItemViewModel
import com.example.demoapp.viewModels.RestaurantListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param postListViewModel PostListViewModel in which to inject the dependencies
     */
    fun inject(restaurantListViewModel: RestaurantListViewModel)
    /**
     * Injects required dependencies into the specified PostViewModel.
     * @param postViewModel PostViewModel in which to inject the dependencies
     */
    fun inject(RestaurantItemViewModel: RestaurantItemViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}