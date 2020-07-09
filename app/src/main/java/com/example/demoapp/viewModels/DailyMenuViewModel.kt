package com.example.demoapp.viewModels

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.demoapp.DailyMenuActivity
import com.example.demoapp.ViewCartActivity
import com.example.demoapp.adapters.DailyMenuAdapter
import com.example.demoapp.global.Constant
import com.example.demoapp.models.DailyMenuModel
import com.example.demoapp.models.Nearby_restaurants
import com.example.demoapp.models.ViewCartModel
import com.example.demoapp.serviceHandlers.LoadingState
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await


class DailyMenuViewModel: BaseViewModel() {
    val dailyMenuAdapter: DailyMenuAdapter = DailyMenuAdapter()
    var totalPrice : MutableLiveData<String> = MutableLiveData()


    lateinit var dataList: List<DailyMenuModel>
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

      var dailyMenuActivity: DailyMenuActivity = DailyMenuActivity()
    lateinit var nearbyRestaurants: Nearby_restaurants
    fun bind(
        dailyMenuActivity: DailyMenuActivity,
        nearbyRestaurants: Nearby_restaurants ) {
        this.dailyMenuActivity = dailyMenuActivity
        this.nearbyRestaurants = nearbyRestaurants

    }


  var _loading: MutableLiveData<LoadingState> = MutableLiveData<LoadingState>()

    init {
        getMenuListFromFireStore()

    }

    private val viewModelJob = SupervisorJob()


    private fun getMenuListFromFireStore() {

        CoroutineScope(Dispatchers.Main).launch {
            print(Thread.currentThread().name)

            val deferred = CoroutineScope(Dispatchers.IO).async{
                //Working on background thread
                dataList =  getDailyMenu()
                CoroutineScope(Dispatchers.Main).launch {
                    mIssuePostLiveData.value = dataList
                }

            }.await()

        }



        _loading.observe(dailyMenuActivity, Observer { it ->

           when(it.status){
               LoadingState.Status.RUNNING->{
                   Toast.makeText(dailyMenuActivity,"running",Toast.LENGTH_LONG).show()
               }
               LoadingState.Status.SUCCESS->{
                   Toast.makeText(dailyMenuActivity,"Done",Toast.LENGTH_LONG).show()
               }
               LoadingState.Status.FAILED->{
                   Toast.makeText(dailyMenuActivity,"Wrong",Toast.LENGTH_LONG).show()
               }
           }
        })
    }

    var price = 0f

     fun priceCalculate(){
        price = 0f
         viewCartList.clear()
         var discount = 0f
        for (i in dataList.indices){
            var dailyMenuModel = dataList.get(i)
            if(dailyMenuModel.selectedQuantity>0){
                viewCartList.put(dailyMenuModel.id,ViewCartModel(nearbyRestaurants,dailyMenuModel))
                discount = dailyMenuModel.discount
                price += dailyMenuModel.selectedQuantity * dailyMenuModel.rate
            }
        }
         if(price > 0){
             price -= (price * discount / 100)
         }
        totalPrice.value = "Payable Amount: $price"
    }


















     val mIssuePostLiveData = MutableLiveData<List<DailyMenuModel>>()
     suspend fun  getDailyMenu() : List<DailyMenuModel>{
        // Create a reference to the cities collection
        val citiesRef = dailyMenuActivity.firestore.collection(Constant.DAILYMENU).get().await()
        val johnUser = citiesRef.toObjects(DailyMenuModel::class.java)
         return johnUser
    }

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()


    fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE


    }

    fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE

    }

    fun viewCartVisibility() {
        var flag = 0

        for (i in dataList.indices){
            var dailyMenuModel = dataList.get(i)
            if(dailyMenuModel.selectedQuantity>0){


                flag++
                break
            }
        }

        if(flag>0){
            onRetrievePostListStart()
        }else{
            onRetrievePostListFinish()
        }
    }

    fun viewCartEventHandler(view: View){


        var intent = Intent(dailyMenuActivity, ViewCartActivity::class.java)
        intent.putExtra(Constant.OBJECT, viewCartList)
        dailyMenuActivity.startActivity(intent)
    }


    var viewCartList : HashMap<Int, ViewCartModel> = HashMap<Int, ViewCartModel> ()



}