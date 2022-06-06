package com.traveloka.bestpriceapp.ui.voucher.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.traveloka.bestpriceapp.R

class ListVoucherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_list_voucher)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}