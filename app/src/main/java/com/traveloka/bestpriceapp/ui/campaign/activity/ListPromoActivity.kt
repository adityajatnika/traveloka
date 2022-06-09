package com.traveloka.bestpriceapp.ui.campaign.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.traveloka.bestpriceapp.databinding.ActivityListPromoBinding

class ListPromoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListPromoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListPromoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}