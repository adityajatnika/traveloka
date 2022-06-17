package com.traveloka.bestpriceapp.ui.product.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.traveloka.bestpriceapp.R
import androidx.core.util.Pair
import com.traveloka.bestpriceapp.data.remote.response.ProductItem
import com.traveloka.bestpriceapp.databinding.ItemRowProductBinding
import com.traveloka.bestpriceapp.ui.product.activity.DetailProductActivity
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


class ListProductAdapter(private val listProduct: List<ProductItem>) : RecyclerView.Adapter<ListProductAdapter.ListViewHolder>() {

//    private lateinit var onItemClickCallback: OnItemClickCallback
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }
//
//    interface OnItemClickCallback {
//        fun onItemClicked(data: ProductItem)
//    }


    class ListViewHolder(private val binding: ItemRowProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductItem) {
            val img = when(product.productCategory){
                "perfumery" -> R.drawable.perfumery
                "bed_bath_table" -> R.drawable.bed_bath_table
                "health_beauty" -> R.drawable.health_beauty
                "sports_leisure" -> R.drawable.sport_leisure
                "furniture_decor" -> R.drawable.furniture_decor
                "computers_accessories" -> R.drawable.computer_accessories
                "housewares" -> R.drawable.housewares
                "watches_gifts" -> R.drawable.watches_gifts
                "telephony" -> R.drawable.telephony
                "garden_tools" -> R.drawable.garden_tools
                "auto" -> R.drawable.auto
                "cool_stuff" -> R.drawable.cool_stuff
                else -> {
                    R.drawable.ic_baseline_image_24
                }
            }

            Glide.with(itemView.context)
                .load(img)
                .into(binding.imgItemPhoto)
            binding.tvItemName.text = product.name
            fun String.toCamelCase() =
                split('_').joinToString(" ", transform = String::capitalize)
            binding.tvItemCategory.text = product.productCategory.toCamelCase()
            binding.tvBestPrice.text = StringBuilder("Rp ").append(formatter.format(product.finalPrice))

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailProductActivity::class.java)
                intent.putExtra(DetailProductActivity.EXTRA_PRODUCT, product)

                val optionsCompat: ActivityOptionsCompat =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        itemView.context as Activity,
                        Pair(binding.imgItemPhoto, "photo"),
                        Pair(binding.tvItemName, "name"),
                        Pair(binding.tvBestPrice, "price"),
                    )
                itemView.context.startActivity(intent, optionsCompat.toBundle())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listProduct[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listProduct.size

    //    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
//        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
//        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_category)
//    }

    companion object{
        var formatter: NumberFormat = DecimalFormat("#,###")
    }
}