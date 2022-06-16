package com.traveloka.bestpriceapp.ui.voucher.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.traveloka.bestpriceapp.data.remote.response.ProductItem
import com.traveloka.bestpriceapp.data.remote.response.VoucherItem
import com.traveloka.bestpriceapp.databinding.ItemRowProductBinding
import com.traveloka.bestpriceapp.databinding.ItemVoucherBinding
import com.traveloka.bestpriceapp.ui.voucher.activity.DetailVoucherActivity

class ListVoucherAdapter(private val listVoucher: List<VoucherItem>) :
    RecyclerView.Adapter<ListVoucherAdapter.ListViewHolder>() {


    class ListViewHolder(private val binding: ItemVoucherBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(voucher: VoucherItem) {
            binding.tvNama.text = voucher.name
//            fun String.toCamelCase() =
//                split('_').joinToString(" ", transform = String:: capitalize)
//            binding.tvCategory.text = voucher.categoryName.toCamelCase()
//            binding.tvDiscount.text = voucher.discountPercent

            //        itemView.setOnClickListener {
//            val intent = Intent(itemView.context, DetailVoucherActivity::class.java)
//            intent.putExtra(DetailVoucherActivity.)
//        }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemVoucherBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listVoucher[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listVoucher.size
}