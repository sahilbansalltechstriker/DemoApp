package com.example.demoapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapp.DailyMenuActivity
import com.example.demoapp.R
import com.example.demoapp.RestaurantDetail
import com.example.demoapp.databinding.HomeFragmentBinding
import com.example.demoapp.global.Constant
import com.example.demoapp.global.RecyclerTouchListener
import com.example.demoapp.global.RecyclerTouchListener.ClickListener
import com.example.demoapp.serviceHandler.RestaurantRepository
import com.example.demoapp.viewModels.RestaurantListViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.home_fragment.*
import net.gahfy.mvvmposts.injection.BaseViewModelFactory


class HomeFragment : Fragment(){

        private lateinit var binding: HomeFragmentBinding
        private lateinit var viewModel: RestaurantListViewModel
        private var errorSnackbar: Snackbar? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding = DataBindingUtil.inflate( inflater, R.layout.home_fragment, container, false)
        // Inflate the layout for this fragment


        binding!!.rvList.layoutManager = LinearLayoutManager(activity!!.application, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this, BaseViewModelFactory { RestaurantListViewModel() }).get(RestaurantListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })


        binding.viewModel = viewModel
        var  view = binding?.root
        binding!!.rvList.addOnItemTouchListener(
            RecyclerTouchListener(
                activity,
                binding!!.rvList,
                object : ClickListener {
                    override fun onClick(view: View?, position: Int) {

                        var nearbyRestaurants = viewModel.restaurantListAdapter.restaurantList.get(position)
                        var intent = Intent(activity, DailyMenuActivity::class.java)
                        intent.putExtra(Constant.OBJECT, nearbyRestaurants)
                        startActivity(intent)

                    }

                    override fun onLongClick(view: View?, position: Int) {}
                })
        )
        return  view!!
    }

    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }


}