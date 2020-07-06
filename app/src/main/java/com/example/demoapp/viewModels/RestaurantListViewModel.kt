package com.example.demoapp.viewModels

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.demoapp.R
import com.example.demoapp.adapters.RestaurantListAdapter
import com.example.demoapp.models.Nearby_restaurants
import com.example.demoapp.models.RestaurantModel
import com.example.demoapp.serviceHandler.MyApi
import com.example.demoapp.serviceHandler.RestaurantRepository
import io.reactivex.disposables.Disposable
import javax.inject.Inject


class RestaurantListViewModel ():BaseViewModel(){
    @Inject
    lateinit var postApi: MyApi
    val restaurantListAdapter: RestaurantListAdapter = RestaurantListAdapter()
    lateinit var all: List<RestaurantModel>
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadRestaurants() }

    private lateinit var subscription: Disposable

    init{
        loadRestaurants()
    }

    override fun onCleared() {
        super.onCleared()
       // subscription.dispose()
    }


    lateinit var list : MutableLiveData<List<Nearby_restaurants>>
    public fun loadRestaurants(){
        onRetrievePostListStart()
        RestaurantRepository().getRestaurantList(this)

        //onRetrievePostListSuccess(list.value as List<NearbyRestaurant>)
/*
        Single.fromCallable({ RetrofitClient.service.getAllRestaurants() }).
        subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }

            .subscribe({ result -> onRetrievePostListSuccess(result as Call<RestaurantModel>) },

                { error -> onRetrievePostListError() })*/
      /* subscription = Observable.fromCallable { restaurantDao.all }
            .concatMap {
                    dbPostList ->
                if(dbPostList.toString().isNullOrEmpty())
                    postApi.getAllRestaurants().concatMap {
                            apiPostList ->
                        restaurantDao.insertAll(*apiPostList.toTypedArray())
                        Observable.just(apiPostList)
                    }
                else
                    Observable.just(dbPostList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result as List<RestaurantModel>) },
                { onRetrievePostListError() }
            )*/
    }

    public fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    public fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    public fun onRetrievePostListSuccess(postList: List<Nearby_restaurants>){
        restaurantListAdapter.updatePostList(postList)
        onRetrievePostListFinish()
    }

    public fun onRetrievePostListError(){
        errorMessage.value = R.string.post_error
    }
}