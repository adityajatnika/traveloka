package com.traveloka.bestpriceapp.ui.campaign.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.traveloka.bestpriceapp.databinding.ActivityAddCampaignBinding


class AddCampaignActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddCampaignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Tambah Campaign"

        binding = ActivityAddCampaignBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            Toast.makeText(this,"Campaign telah ditambah", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}