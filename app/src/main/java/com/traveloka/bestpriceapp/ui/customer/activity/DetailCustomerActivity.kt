package com.traveloka.bestpriceapp.ui.customer.activity

import android.content.ContentValues.TAG
import android.nfc.NfcAdapter.EXTRA_ID
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.KeyChain.EXTRA_NAME
import android.util.Log
import com.bumptech.glide.Glide
import com.traveloka.bestpriceapp.R
import com.traveloka.bestpriceapp.data.remote.Customer
import com.traveloka.bestpriceapp.data.remote.response.CustomerItem
import com.traveloka.bestpriceapp.databinding.ActivityDetailCustomerBinding


class DetailCustomerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailCustomerBinding
    //private val viewModel: DetailCustomerViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_customer)

        supportActionBar?.title = "Detail Customer"

        binding = ActivityDetailCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()


    }
    private fun setUpView() {
        binding.apply {
            val name = intent.getStringExtra(EXTRA_NAME)
            val id = intent.getStringExtra(EXTRA_ID)
            Log.e(TAG, name.toString())
            val img = R.drawable.user
            Glide.with(applicationContext)
                .load(img)
                .into(imageView)
            tvId.text = id.toString()
            tvName.text = name.toString()
            tvVoucher.text

        }
    }
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_ID = "extra_id"
    }
}