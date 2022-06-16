package com.traveloka.bestpriceapp.ui.customer.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.traveloka.bestpriceapp.databinding.ActivityDetailCustomerBinding

class DetailCustomerActivity : AppCompatActivity() {
    private lateinit var binding :ActivityDetailCustomerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}