package com.traveloka.bestpriceapp.ui.campaign.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.traveloka.bestpriceapp.databinding.ActivityAddPromoBinding

class AddPromoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddPromoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPromoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}