package com.traveloka.bestpriceapp.ui.campaign.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.traveloka.bestpriceapp.databinding.ActivityAddCampaignBinding

class AddCampaignActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddCampaignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCampaignBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}