package com.traveloka.bestpriceapp.ui.campaign.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.traveloka.bestpriceapp.R
import androidx.core.util.Pair
import com.google.gson.annotations.SerializedName
import com.traveloka.bestpriceapp.data.remote.response.CampaignItem
import com.traveloka.bestpriceapp.data.remote.response.ProductItem
import com.traveloka.bestpriceapp.data.remote.response.PromoItem
import com.traveloka.bestpriceapp.databinding.ItemRowCampaignBinding
import com.traveloka.bestpriceapp.databinding.ItemRowProductBinding
import com.traveloka.bestpriceapp.ui.product.activity.DetailProductActivity
import com.traveloka.bestpriceapp.ui.product.adapter.CategoryProduct
import com.traveloka.bestpriceapp.ui.product.adapter.ListCategoryAdapter
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


class ListCampaignForecastAdapter(private val listCampaigns: List<CampaignItem>) : RecyclerView.Adapter<ListCampaignForecastAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: CategoryProduct)
    }


    class ListViewHolder(private val binding: ItemRowCampaignBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(campaign: CampaignItem) {

//            fun String.toCamelCase() =
//                split('_').joinToString(" ", transform = String::capitalize)
//            binding.tvItemCategory.text = product.productCategory.toCamelCase()
//            binding.tvBestPrice.text = StringBuilder("Rp ").append(formatter.format(product.finalPrice))

            if (campaign.promo.isNotEmpty()){
                binding.tvItemPromo.text = campaign.promo[0].name
            } else {
                binding.tvItemPromo.text = "no promo"
            }
            binding.tvItemName.text = campaign.name
            binding.swbCampaign.isChecked = campaign.isActive
//            binding.swbCampaign.setOnClickListener{
//                OnItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
//            }

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
        val data = listCampaigns[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listCampaigns.size






//    private lateinit var onItemClickCallback: OnItemClickCallback
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }
//
//    interface OnItemClickCallback {
//        fun onItemClicked(data: CampaignItem)
//    }
//
//    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var swbCampaign : SwitchCompat = itemView.findViewById(R.id.swb_campaign)
//        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
//        var tvPromo : TextView = itemView.findViewById(R.id.tv_item_promo)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_category, parent, false)
//        return ListViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        val (endDate,promo, isActive, updatedAt,periodical,  everyWeekend, name,  createdAt, id, startDate) = listCampaigns[position]
//        holder.tvName.text = name
//        holder.tvPromo
//        if (promo.isNotEmpty()){
//            holder.tvPromo.text = promo[0].name
//        } else {
//            holder.tvPromo.text = "no promo"
//        }
//        holder.swbCampaign.isChecked = isActive
//        holder.swbCampaign.setOnClickListener{
//            onItemClickCallback.onItemClicked(listCampaigns[holder.adapterPosition])
//        }
////        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }
//    }
//    override fun getItemCount(): Int = listCampaigns.size

}