package com.traveloka.bestpriceapp.ui.product.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.traveloka.bestpriceapp.R
import androidx.core.util.Pair
import com.traveloka.bestpriceapp.data.remote.response.ProductItem
import com.traveloka.bestpriceapp.databinding.ItemRowProductBinding
import com.traveloka.bestpriceapp.ui.product.activity.DetailProductActivity
import com.traveloka.bestpriceapp.ui.product.fragment.ProductFragment
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


class ListCategoryAdapter(private val listUser: ArrayList<CategoryProduct>) : RecyclerView.Adapter<ListCategoryAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: CategoryProduct)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var btCategory: TextView = itemView.findViewById(R.id.bt_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_category, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name) = listUser[position]
        holder.btCategory.text = name
//        holder.btCategory.setOnClickListener{
//
//        }
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listUser.size

}


data class CategoryProduct(
    var categoryName: String,
)
