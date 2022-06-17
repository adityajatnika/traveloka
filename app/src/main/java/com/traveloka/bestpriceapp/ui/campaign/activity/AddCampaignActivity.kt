package com.traveloka.bestpriceapp.ui.campaign.activity

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.traveloka.bestpriceapp.R
import com.traveloka.bestpriceapp.data.remote.Campaign
import com.traveloka.bestpriceapp.data.remote.Customer
import com.traveloka.bestpriceapp.data.remote.response.CampaignCallResponse
import com.traveloka.bestpriceapp.data.remote.response.CampaignItem
import com.traveloka.bestpriceapp.data.remote.retrofit.ApiConfig
import com.traveloka.bestpriceapp.databinding.ActivityAddCampaignBinding
import com.traveloka.bestpriceapp.databinding.ActivityAddPromoBinding
import com.traveloka.bestpriceapp.ui.campaign.fragment.CampaignFragment
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback

class AddCampaignActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddCampaignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Tambah Promo"

        binding = ActivityAddCampaignBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            Toast.makeText(this,"List Promo telah ditambah", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

//    private lateinit var binding: ActivityAddCampaignBinding
//    @SuppressLint("SetTextI8n")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_campaign)
//
//        binding = ActivityAddCampaignBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.progressBar.visibility = View.INVISIBLE
//
//        val campaign = intent.getParcelableExtra<Campaign?>(CampaignFragment.EXTRA_CAMPAIGN) as Customer?
//
//        if (campaign != null){
//            supportActionBar.title = "Edit Campaign"
//            binding.btnSave.text = "Save Changes"
//            setUpView()
//        }else {
//            binding.btnSave.text = "Add Campaign"
//            supportActionBar.title = "Add New Product"
//        }
//
//        binding.btnSave.setOnClickListener {
//            updateCampaign(campaign)
//        }
//
//        binding.btnChange.setOnClickListener {
//            changePhoto()
//        }
//
//        binding.btnBack.setOnClickListener {
//            finish()
//        }
//    }
//
//    private fun updateCampaign(campaign: CampaignItem? = null){
//        binding.progressBar.visibility = View.VISIBLE
//
//        if (binding.editTextTextPersonName.text == null &&
//            binding.editTextDate.text == null &&
//            binding.editTextDate2.text == null &&
//                binding.editTextTextPersonName5.text == null){
//            Toast.makeText(this@AddCampaignActivity, "Please fill out the form first", Toast.LENGTH_SHORT).show()
//        } else {
//            val jsonObject = JSONObject()
//            jsonObject.put("name", binding.editTextTextPersonName.text.toString())
//            jsonObject.put("start_date", binding.editTextDate.text.toString().toDouble())
//            jsonObject.put("end_date", binding.editTextDate2.text.toString().toDouble())
//            jsonObject.put("desc", binding.editTextTextPersonName5.text.toString())
//
//            val jsonObjectString = jsonObject.toString()
//            val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())
//
//            val service : Call<CampaignCallResponse> = if (campaign != null){
//                ApiConfig.getApiService().updateCampaign(
//                    id = campaign.id,
//                    requestBody = requestBody)
//            } else {
//                ApiConfig.getApiService().addCampaign(
//                    requestBody
//                )
//            }
//            Log.e(TAG, "sampai sini")
//            service.enqueue(object : Callback<CampaignCallResponse>{
//                override
//            } )
//        }
//    }
}