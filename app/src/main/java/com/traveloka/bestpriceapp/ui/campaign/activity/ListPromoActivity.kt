package com.traveloka.bestpriceapp.ui.campaign.activity

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.traveloka.bestpriceapp.databinding.ActivityListPromoBinding
import com.traveloka.bestpriceapp.ui.campaign.adapter.ListPromoAdapter
import com.traveloka.bestpriceapp.ui.campaign.viewmodel.ListPromoViewModel

class ListPromoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListPromoBinding
    private val viewModel: ListPromoViewModel by viewModels()
    private val adapter = ListPromoAdapter(ArrayList())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListPromoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }


    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvPromo.layoutManager = GridLayoutManager(applicationContext, 2)
        } else {
            binding.rvPromo.layoutManager = LinearLayoutManager(applicationContext)
        }
    }

    private fun setUpView() {
        showRecyclerList()

        viewModel.isLoading.observe(this) {
            binding.progressBar.visibility = if (it) {
                View.VISIBLE
            } else {
                View.INVISIBLE
            }
        }

        viewModel.promo.observe(this) {
            if (it != null) {
                val adapter = ListPromoAdapter(it)
                binding.rvPromo.adapter = adapter

//
            }
        }

        viewModel.stringError.observe(this) {
            if (it != null) {
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}