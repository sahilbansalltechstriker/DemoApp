package com.example.demoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.R
import com.example.demoapp.databinding.CartViewItemBinding
import com.example.demoapp.models.ViewCartModel
import com.example.demoapp.viewModels.CartViewItemModel


class ViewCartAdapter : RecyclerView.Adapter<ViewCartAdapter.ViewHolder>() {
     lateinit var mKeys: MutableSet<Int>
    lateinit var cartList : HashMap<Int, ViewCartModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewCartAdapter.ViewHolder {
        val binding: CartViewItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.cart_view_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val key = getKey(position)
        holder.bind(key,cartList)
    }

    override fun getItemCount(): Int {
        return if(::cartList.isInitialized) cartList.size else 0
    }

    fun updateCartList(cartList: HashMap<Int, ViewCartModel>){
        this.cartList = cartList

          mKeys = cartList.keys
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: CartViewItemBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = CartViewItemModel()

        fun bind(
            key: Int?,
            cartList: HashMap<Int, ViewCartModel>
        ){



            binding.viewModel = viewModel
           viewModel.bind(cartList[key])
        }
    }

    fun getKey(position: Int): Int? {
        return mKeys.elementAt(position)
    }

}