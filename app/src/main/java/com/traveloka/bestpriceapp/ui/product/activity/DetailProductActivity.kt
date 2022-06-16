package com.traveloka.bestpriceapp.ui.product.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.StringRes
import com.bumptech.glide.Glide
import com.traveloka.bestpriceapp.R
import com.traveloka.bestpriceapp.data.remote.Product
import com.traveloka.bestpriceapp.data.remote.response.ProductItem
import com.traveloka.bestpriceapp.databinding.ActivityDetailProductBinding
import com.traveloka.bestpriceapp.ui.product.adapter.ListProductAdapter

//import com.traveloka.bestpriceapp.ui.product.viewmodel.DetailProductViewModel

class DetailProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProductBinding
    //    private val viewModel: DetailProductViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        supportActionBar?.title = "Detail Product"

        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()
        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT) as ProductItem
        binding.btEdit.setOnClickListener {
            val intent = Intent(this@DetailProductActivity, AddProductActivity::class.java)
            intent.putExtra(AddProductActivity.EXTRA_PRODUCT, product)
            startActivity(intent)
            finish()
        }

    }

    private fun setUpView() {
        binding.apply {
            val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT) as ProductItem
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

            Glide.with(applicationContext)
                .load(img)
                .into(imgProduct)
            tvName.text = product.name
            tvCategory.text = product.productCategory.toCamelCase()
            tvPrice.text = StringBuilder("Rp ").append(ListProductAdapter.formatter.format(product.finalPrice))
            tvCompetitorPrice.text = StringBuilder("Competitor Price : Rp ").append(ListProductAdapter.formatter.format(product.competitorPrice))
            tvDetail.text = "LoremLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."

        }
    }
    companion object{
        const val EXTRA_PRODUCT = "extra_product"
        fun String.toCamelCase() =
            split('_').joinToString(" ", transform = String::capitalize)
    }
}