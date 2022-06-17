package com.traveloka.bestpriceapp.ui.voucher.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.traveloka.bestpriceapp.databinding.ActivityDetailVoucherBinding
import com.traveloka.bestpriceapp.ui.voucher.fragment.VoucherFragment

class AddVoucherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailVoucherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Tambah voucher"

        binding = ActivityDetailVoucherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSave.setOnClickListener {
            Toast.makeText(this,"List voucher telah ditambah", Toast.LENGTH_SHORT).show()
        finish()
        }



    }

}
