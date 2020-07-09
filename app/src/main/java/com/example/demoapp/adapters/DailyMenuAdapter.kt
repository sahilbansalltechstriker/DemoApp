package com.example.demoapp.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.DailyMenuActivity
import com.example.demoapp.R
import com.example.demoapp.databinding.DailymenuItemBinding
import com.example.demoapp.models.DailyMenuModel
import com.example.demoapp.models.Nearby_restaurants
import com.example.demoapp.viewModels.DailyMenuItemViewModel


class DailyMenuAdapter: RecyclerView.Adapter<DailyMenuAdapter.ViewHolder>() {
    lateinit var menuList:List<DailyMenuModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyMenuAdapter.ViewHolder {
        val binding: DailymenuItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.dailymenu_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(menuList[position],activity,this)
    }

    override fun getItemCount(): Int {
        return if(::menuList.isInitialized) menuList.size else 0
    }

    fun updatePostList(menuList: List<DailyMenuModel>){
        this.menuList = menuList
        notifyDataSetChanged()
    }

    lateinit var activity: DailyMenuActivity
    fun updateInstance(
        activity: DailyMenuActivity
    ) {

        this.activity = activity
    }


    class ViewHolder(private val binding: DailymenuItemBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = DailyMenuItemViewModel()

        fun bind(
            post: DailyMenuModel,
            activity: DailyMenuActivity,
            dailyMenuAdapter: DailyMenuAdapter
        ){

            binding.viewModel = viewModel

            viewModel.bind(post,activity,dailyMenuAdapter)
        }
    }
}