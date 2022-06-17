package com.traveloka.bestpriceapp.ui.campaign.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.traveloka.bestpriceapp.R
import androidx.core.util.Pair
import com.traveloka.bestpriceapp.data.remote.response.CampaignItem
import com.traveloka.bestpriceapp.data.remote.response.ProductItem
import com.traveloka.bestpriceapp.databinding.ItemRowCampaignBinding
import com.traveloka.bestpriceapp.databinding.ItemRowProductBinding
import com.traveloka.bestpriceapp.ui.product.activity.DetailProductActivity
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


class ListCampaignForecastAdapter(private val listProduct: List<CampaignItem>) : RecyclerView.Adapter<ListCampaignForecastAdapter.ListViewHolder>() {

//    private lateinit var onItemClickCallback: OnItemClickCallback
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }
//
//    interface OnItemClickCallback {
//        fun onItemClicked(data: ProductItem)
//    }


    class ListViewHolder(private val binding: ItemRowCampaignBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(campaign: CampaignItem) {

//            fun String.toCamelCase() =
//                split('_').joinToString(" ", transform = String::capitalize)
//            binding.tvItemCategory.text = product.productCategory.toCamelCase()
//            binding.tvBestPrice.text = StringBuilder("Rp ").append(formatter.format(product.finalPrice))

            binding.tvItemName.text = campaign.name
            binding.tvItemPromo.text = campaign.promo[0].name
            binding.swbCampaign.isChecked = campaign.isActive

//            itemView.setOnClickListener {
//                val intent = Intent(itemView.context, DetailProductActivity::class.java)
//                intent.putExtra(DetailProductActivity.EXTRA_PRODUCT, product)
//
//                val optionsCompat: ActivityOptionsCompat =
//                    ActivityOptionsCompat.makeSceneTransitionAnimation(
//                        itemView.context as Activity,
//                        Pair(binding.imgItemPhoto, "photo"),
//                        Pair(binding.tvItemName, "name"),
//                        Pair(binding.tvBestPrice, "price"),
//                    )
//                itemView.context.startActivity(intent, optionsCompat.toBundle())
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowCampaignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listProduct[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listProduct.size

}