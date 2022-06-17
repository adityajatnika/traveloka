package com.traveloka.bestpriceapp.ui.campaign.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.traveloka.bestpriceapp.R
import com.traveloka.bestpriceapp.data.remote.response.CampaignItem
import com.traveloka.bestpriceapp.databinding.LayoutListCampaignBinding
import com.traveloka.bestpriceapp.ui.campaign.activity.ListPromoActivity

class ListCampaignAdapter(private val listCampaign: List<CampaignItem>) : RecyclerView.Adapter<ListCampaignAdapter.ListViewHolder>() {

    class ListViewHolder(private val binding: LayoutListCampaignBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(campaigns : CampaignItem) {
            val img = R.drawable.campaign
            Glide.with(itemView.context)
                .load(img)
                .into(binding.ivUser)
            binding.tvDesc
            binding.tvName.text = campaigns.name

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, ListPromoActivity::class.java)

                val optionsCompat: ActivityOptionsCompat =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        itemView.context as Activity,
                        Pair(binding.ivUser, "photo"),
                        Pair(binding.tvDesc, "desc"),
                        Pair(binding.tvName, "name")
                    )
                itemView.context.startActivity(intent, optionsCompat.toBundle())
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ListCampaignAdapter.ListViewHolder {
        val binding = LayoutListCampaignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListCampaignAdapter.ListViewHolder, position: Int) {
        val data = listCampaign[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listCampaign.size

}