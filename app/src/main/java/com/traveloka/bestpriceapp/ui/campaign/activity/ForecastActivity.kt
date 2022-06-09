package com.traveloka.bestpriceapp.ui.campaign.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.traveloka.bestpriceapp.databinding.ActivityForecastBinding

class ForecastActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForecastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForecastBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}