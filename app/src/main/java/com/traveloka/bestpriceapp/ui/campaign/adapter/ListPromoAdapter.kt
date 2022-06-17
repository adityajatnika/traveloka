package com.traveloka.bestpriceapp.ui.campaign.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.traveloka.bestpriceapp.data.remote.response.PromoItem
import com.traveloka.bestpriceapp.databinding.ItemPromoBinding
import java.text.DecimalFormat
import java.text.NumberFormat

class ListPromoAdapter (private val listPromo: List<PromoItem>) :
RecyclerView.Adapter<ListPromoAdapter.ListViewHolder>(){

    class ListViewHolder(private val binding: ItemPromoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(promo: PromoItem) {
            binding.tvNamaPromo.text = promo.name

            binding.tvCategory.text = StringBuilder("Untuk kategori : ").append(promo.categoryName)
            val maxDiscount= formatter.format(promo.maxDiscount)
            binding.tvDiscount.text = StringBuilder("Discount sebesar : ").append(promo.discount.toString())
            binding.tvMaxdiscount.text = StringBuilder(" Hingga : Rp").append(maxDiscount.toString())
//            binding.tvMulai.text = promo.createdAt
//            binding.tvBatas.text = promo.updatedAt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemPromoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listPromo[position]
        holder.bind(data)
    }
    override fun getItemCount(): Int = listPromo.size

    companion object{
        var formatter: NumberFormat = DecimalFormat("#,###")
    }
}