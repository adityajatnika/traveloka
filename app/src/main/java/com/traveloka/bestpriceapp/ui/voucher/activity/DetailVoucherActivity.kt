package com.traveloka.bestpriceapp.ui.voucher.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.traveloka.bestpriceapp.R
import com.traveloka.bestpriceapp.databinding.ActivityDetailVoucherBinding

class DetailVoucherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailVoucherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "List Voucher"

        binding = ActivityDetailVoucherBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }

}
