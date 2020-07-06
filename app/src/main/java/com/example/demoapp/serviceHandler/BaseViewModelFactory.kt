package net.gahfy.mvvmposts.injection


import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.demoapp.viewModels.RestaurantListViewModel


 class BaseViewModelFactory<T>(val creator: () -> T) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return creator() as T
        }
    }
/*
class ViewModelFactory(private val activity: FragmentActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestaurantListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "restaurant").build()
            @Suppress("UNCHECKED_CAST")
            return RestaurantListViewModel(db.restaurantDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}*/
