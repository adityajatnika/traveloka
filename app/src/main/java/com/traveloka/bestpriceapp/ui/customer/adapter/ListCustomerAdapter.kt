package com.traveloka.bestpriceapp.ui.customer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.traveloka.bestpriceapp.data.remote.Customer
import com.traveloka.bestpriceapp.data.remote.response.CustomerItem
import com.traveloka.bestpriceapp.databinding.LayoutListCustomerBinding

class ListCustomerAdapter(list: List<CustomerItem>) : RecyclerView.Adapter<ListCustomerAdapter.CustomerViewHolder>(){

    private val list = ArrayList<Customer>()

    fun setList(customers: ArrayList<Customer>){
        list.clear()
        list.addAll(customers)
        notifyDataSetChanged()
    }

    inner class CustomerViewHolder(val binding: LayoutListCustomerBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(customer: Customer){
            binding.apply {
                Glide.with(itemView)
                    .load(customer.img)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(ivUser)
                tvName.text = customer.name
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val view = LayoutListCustomerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomerViewHolder((view))
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}