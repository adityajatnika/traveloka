package com.traveloka.bestpriceapp.ui.campaign.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.traveloka.bestpriceapp.databinding.ActivityAddPromoBinding

class AddPromoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddPromoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Tambah Promo"

        binding = ActivityAddPromoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSave.setOnClickListener {
            Toast.makeText(this,"List Promo telah ditambah", Toast.LENGTH_SHORT).show()
            finish()
        }



    }
}