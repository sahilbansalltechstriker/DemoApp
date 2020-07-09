package com.example.demoapp

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapp.databinding.DailymenuBinding
import com.example.demoapp.global.Constant
import com.example.demoapp.models.Nearby_restaurants
import com.example.demoapp.viewModels.DailyMenuViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import net.gahfy.mvvmposts.injection.BaseViewModelFactory


class DailyMenuActivity :BaseActivity<DailymenuBinding>() {
    // Access a Cloud Firestore instance from your Activity
    val firestore = Firebase.firestore
    lateinit var binding : DailymenuBinding
    lateinit var viewModel : DailyMenuViewModel
    lateinit var nearbyRestaurants : Nearby_restaurants
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //get reference from baseclass
        binding = (dataBinding as DailymenuBinding)
        viewModel = ViewModelProviders.of(this).get(DailyMenuViewModel::class.java)

        binding.viewModel = viewModel




        binding!!.rvDailyMenuList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this, BaseViewModelFactory { DailyMenuViewModel() }).get(
            DailyMenuViewModel::class.java)
        viewModel.mIssuePostLiveData.observe(this, Observer {
            viewModel.dailyMenuAdapter.updatePostList(it)
        })

        nearbyRestaurants = intent.getParcelableExtra<Nearby_restaurants>(Constant.OBJECT) as Nearby_restaurants
        setToolBarWithTitle(true, nearbyRestaurants.restaurant?.name!!)
        //set activity reference for sending the context
        viewModel.bind(this,nearbyRestaurants)
        viewModel.dailyMenuAdapter.updateInstance(this)
/*
        binding!!.rvDailyMenuList.addOnItemTouchListener(
            RecyclerTouchListener(
                this,
                binding!!.rvDailyMenuList,
                object : RecyclerTouchListener.ClickListener {
                    override fun onClick(view: View?, position: Int) {

                        var nearbyRestaurants = viewModel.restaurantListAdapter.restaurantList.get(position)
                        var intent = Intent(activity, DailyMenuActivity::class.java)
                        //intent.putExtra(Constant.OBJECT, nearbyRestaurants)
                        startActivity(intent)

                    }

                    override fun onLongClick(view: View?, position: Int) {}
                })
        )
*/











for (i in 1..15){


    // Create a new user with a first and last name
   /* val user = hashMapOf(
        "name" to "Burger",
        "description" to "A hamburger (also burger for short) is a sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun. The patty may be pan fried, grilled, smoked or flame broiled. ... There are many international and regional variations of the hamburger.",
        "res_id" to "1",
        "rate" to 59.0,
        "discount" to 10.0,
        "rating" to 4.0,
        "reviewCount" to 0,
        "totalQuantity" to 5,
        "selectedQuantity" to 0,
        "id" to i,
        "image" to "https://firebasestorage.googleapis.com/v0/b/food-delivery-3307d.appspot.com/o/pngtree-classic" +
                "-burger-fresh-veg-transparent-png-background-png-image_4959686.jpg?alt=media&token=666e8945-c6a8-4cfb-a2fb-f7ee13fcf7de"

    )

// Add a new document with a generated ID
         firestore.collection(Constant.DAILYMENU)
             .add(user)
             .addOnSuccessListener { documentReference ->
                 Log.d("++++", "DocumentSnapshot added with ID: ${documentReference.id}")
             }
             .addOnFailureListener { e ->
                 Log.w("++++", "Error adding document", e)
             }*/

     }



    }

    override fun setSupportToolbar() {
        setToolBarWithTitle(true, Constant.REGISTER)
    }


    override fun setLayout(): Int {
        return R.layout.dailymenu
    }

    fun viewCartVisibility() {

           viewModel.viewCartVisibility()
    }

    fun priceCalculating() {
            viewModel.priceCalculate()
    }
}