package com.traveloka.bestpriceapp.ui.customer.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.traveloka.bestpriceapp.R
import com.traveloka.bestpriceapp.data.remote.response.CustomerItem
import com.traveloka.bestpriceapp.databinding.LayoutListCustomerBinding
import com.traveloka.bestpriceapp.ui.customer.activity.DetailCustomerActivity

class ListCustomerAdapter(private val listCustomer: List<CustomerItem>) : RecyclerView.Adapter<ListCustomerAdapter.ListViewHolder>(){

    class ListViewHolder(private val binding: LayoutListCustomerBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(customer: CustomerItem) {
            val img = R.drawable.user
            Glide.with(itemView)
                .load(img)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivUser)
            binding.tvName.text = customer.name

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailCustomerActivity::class.java)
                intent.putExtra(DetailCustomerActivity.EXTRA_ID, customer.id)
                intent.putExtra(DetailCustomerActivity.EXTRA_NAME, customer.name)



                val optionsCompat: ActivityOptionsCompat =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        itemView.context as Activity,
                        Pair(binding.ivUser, "photo"),
                        Pair(binding.tvName, "name")
                    )
                itemView.context.startActivity(intent, optionsCompat.toBundle())
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ListCustomerAdapter.ListViewHolder {
        val binding = LayoutListCustomerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListCustomerAdapter.ListViewHolder, position: Int) {
        val data = listCustomer[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listCustomer.size

}

private fun Intent.putExtra(extraCustomer: String, customer: CustomerItem) {

}
