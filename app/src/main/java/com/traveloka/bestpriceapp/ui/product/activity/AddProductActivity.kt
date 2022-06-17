package com.traveloka.bestpriceapp.ui.product.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bumptech.glide.Glide
import com.traveloka.bestpriceapp.R
import com.traveloka.bestpriceapp.data.remote.Product
import com.traveloka.bestpriceapp.data.remote.response.ProductCallResponse
import com.traveloka.bestpriceapp.data.remote.response.ProductItem
import com.traveloka.bestpriceapp.data.remote.retrofit.ApiConfig
import com.traveloka.bestpriceapp.databinding.ActivityAddProductBinding
import com.traveloka.bestpriceapp.ui.product.fragment.ProductFragment
import com.traveloka.bestpriceapp.ui.product.viewmodel.ProductViewModel.Companion.TAG
import com.traveloka.bestpriceapp.utils.ResponseStatus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddProductBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.INVISIBLE

        val categoryProduct = resources.getStringArray(R.array.product_category)
        val arrayAdapter = ArrayAdapter(this@AddProductActivity, R.layout.item_dropdown, categoryProduct)
        binding.edtCategory.setAdapter(arrayAdapter)
        val product = intent.getParcelableExtra<Product?>(DetailProductActivity.EXTRA_PRODUCT) as ProductItem?
//        services = ApiConfig.getApiService().addProduct()
        if(product != null){
            supportActionBar?.title = "Edit Product"
            binding.btSave.text = "Save Changes"
            setUpView()
        } else {
            binding.btSave.text = "Add Product"
            supportActionBar?.title = "Add New Product"
        }
//        if(binding.edtName.text != null){
//            services = ApiConfig.getApiService().updateProduct(binding.edt)
//        }
        binding.btSave.setOnClickListener {
            updateProduct(product)
        }

        binding.btChangePhoto.setOnClickListener {
            changePhoto()
        }
    }

    private fun updateProduct(product: ProductItem? = null) {
        binding.progressBar.visibility = View.VISIBLE
        if( binding.edtName.text == null &&
            binding.edtBasePrice.text == null &&
                binding.edtCategory.text == null){
            Toast.makeText(this@AddProductActivity, "Please fill the form first", Toast.LENGTH_SHORT).show()
        } else {
            val services: Call<ProductCallResponse> = if (product != null){
                ApiConfig.getApiService().updateProduct(
                    id = product.id,
                    name = binding.edtName.toString(),
                    basePrice = binding.edtBasePrice.text.toString().toDouble())
            } else {
                ApiConfig.getApiService().addProduct(
                    name = binding.edtName.toString(),
                    basePrice = binding.edtBasePrice.text.toString().toDouble(),
                    productCategory = binding.edtCategory.toString()
                )
            }
            services.enqueue(object : Callback<ProductCallResponse> {
                override fun onResponse(
                    call: Call<ProductCallResponse>,
                    response: Response<ProductCallResponse>
                ) {
                    binding.progressBar.visibility = View.INVISIBLE
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            Toast.makeText(this@AddProductActivity, responseBody.message, Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@AddProductActivity, ProductFragment::class.java)
                            startActivity(intent)
                            finish()
                            Log.e(TAG, "sampai sukses")
                        }
                    } else {
                        val errorMessage = when (val statusCode = response.code()) {
                            ResponseStatus.BAD_REQUEST.stat -> "$statusCode : Bad Request"
                            ResponseStatus.FORBIDDEN.stat -> "$statusCode : Forbidden"
                            ResponseStatus.NOT_FOUND.stat -> "$statusCode : Not Found"
                            else -> "$statusCode"
                        }
                        Log.e(TAG, "sampe gagal")
                        Toast.makeText(this@AddProductActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<ProductCallResponse>, t: Throwable) {
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(this@AddProductActivity, "Retrofit Instance Failed", Toast.LENGTH_SHORT).show()
                }
            })
        }

    }

    private fun setUpView() {
        binding.apply {
            val product = intent.getParcelableExtra<Product>(DetailProductActivity.EXTRA_PRODUCT) as ProductItem
            val img = setPhoto(product.productCategory)
            Glide.with(applicationContext)
                .load(img)
                .into(imgProduct)
            edtName.setText(product.name)
            edtBasePrice.setText(product.basePrice.toString())
            edtCategory.setText(product.productCategory)
            edtDesc.setText("LoremLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")
        }
    }

    private fun setPhoto(productCategory: String): Int {
        return when(productCategory){
            "Perfumery" -> R.drawable.perfumery
            "Bed Bath Table" -> R.drawable.bed_bath_table
            "Health Beauty" -> R.drawable.health_beauty
            "Sports Leisure" -> R.drawable.sport_leisure
            "Furniture Decor" -> R.drawable.furniture_decor
            "Computers Accessories" -> R.drawable.computer_accessories
            "Housewares" -> R.drawable.housewares
            "Watches Gifts" -> R.drawable.watches_gifts
            "Telephony" -> R.drawable.telephony
            "Garden Tools" -> R.drawable.garden_tools
            "Auto" -> R.drawable.auto
            "Cool Stuff" -> R.drawable.cool_stuff
            else -> {
                R.drawable.ic_baseline_image_24
            }
        }
    }

    private fun changePhoto() {
        val img = setPhoto(binding.edtCategory.text.toString())
        Glide.with(applicationContext)
            .load(img)
            .into(binding.imgProduct)
        binding.edtCategory
    }
    companion object{
        const val EXTRA_PRODUCT = "extra_product"
        fun String.toCamelCase() =
            split('_').joinToString(" ", transform = String::capitalize)
    }
}