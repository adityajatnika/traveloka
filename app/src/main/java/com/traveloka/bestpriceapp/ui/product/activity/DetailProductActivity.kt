package com.traveloka.bestpriceapp.ui.product.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.traveloka.bestpriceapp.databinding.ActivityDetailProductBinding

class DetailProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}