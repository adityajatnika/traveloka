package com.traveloka.bestpriceapp.ui.customer.activity

import android.content.ContentValues.TAG
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.traveloka.bestpriceapp.R
import com.traveloka.bestpriceapp.databinding.ActivityDetailCustomerBinding
import com.traveloka.bestpriceapp.ui.customer.adapter.VoucherAdapter
import com.traveloka.bestpriceapp.ui.voucher.viewmodel.VoucherViewModel


class DetailCustomerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailCustomerBinding
    private val viewModel: VoucherViewModel by viewModels()
    private val adapter = VoucherAdapter(ArrayList())
    //private val viewModel: DetailCustomerViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_customer)

        supportActionBar?.title = "Detail Customer"

        binding = ActivityDetailCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvVoucher.setHasFixedSize(true)
        binding.rvVoucher.adapter = this@DetailCustomerActivity.adapter
        binding.rvVoucher.layoutManager = LinearLayoutManager(applicationContext)
        setUpData()
        setUpView()
        viewModel.getListVoucher()




    }

    private fun setUpView(){
        showRecyclerlist()

        viewModel.isLoading.observe(this){
            binding.progressBar.visibility = if (it){
                View.VISIBLE
            }else {
                View.INVISIBLE
            }
        }

        viewModel.voucher.observe(this){
            if (it != null){
                val adapter = VoucherAdapter(it)
                binding.rvVoucher.adapter = adapter
            }
        }

        viewModel.stringError.observe(this){
            if (it != null){
                Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showRecyclerlist() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvVoucher.layoutManager = GridLayoutManager(applicationContext, 2)
        } else {
            binding.rvVoucher.layoutManager = LinearLayoutManager(applicationContext)
        }
    }
    private fun setUpData() {
        binding.apply {
            val name = intent.getStringExtra(EXTRA_NAME)
            val id = intent.getStringExtra(EXTRA_ID)
            Log.e(TAG, name.toString())
            val img = R.drawable.user
            Glide.with(applicationContext)
                .load(img)
                .into(imageView)
            tvId.text = id.toString()
            tvName.text = name.toString()
            tvVoucher.text

        }
    }
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_ID = "extra_id"
    }
}