package com.traveloka.bestpriceapp.ui.customer.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.traveloka.bestpriceapp.R
import com.traveloka.bestpriceapp.data.remote.Customer
import com.traveloka.bestpriceapp.data.remote.response.CustomerItem
import com.traveloka.bestpriceapp.databinding.ActivityDetailCustomerBinding
import com.traveloka.bestpriceapp.ui.customer.viewmodel.DetailCustomerViewModel

class DetailCustomerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailCustomerBinding
    //private val viewModel: DetailCustomerViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_customer)

        supportActionBar?.title = "Detail Customer"

        binding = ActivityDetailCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            imageView
            textView2.text
            rvUser
        }
    }
}