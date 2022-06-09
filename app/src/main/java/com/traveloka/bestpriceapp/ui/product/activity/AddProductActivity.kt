package com.traveloka.bestpriceapp.ui.product.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.traveloka.bestpriceapp.databinding.ActivityAddProductBinding


class AddProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}