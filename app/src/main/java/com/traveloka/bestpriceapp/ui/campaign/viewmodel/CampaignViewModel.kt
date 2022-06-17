package com.traveloka.bestpriceapp.ui.campaign.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.traveloka.bestpriceapp.data.remote.response.CampaignCallResponse
import com.traveloka.bestpriceapp.data.remote.response.CampaignItem
import com.traveloka.bestpriceapp.data.remote.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CampaignViewModel : ViewModel() {

    val campaigns = MutableLiveData<List<CampaignItem>>()
    val isLoading = MutableLiveData(true)
    val stringError = MutableLiveData<String>()

    fun getListCampaign() {
        isLoading.postValue(true)
        val client = ApiConfig.getApiService().getCampaigns()
        client.enqueue(object : Callback<CampaignCallResponse> {
            override fun onResponse(
                call: Call<CampaignCallResponse>,
                response: Response<CampaignCallResponse>
            ) {
                isLoading.postValue(false)
                if (response.isSuccessful){
                    val responseBody = response.body()
                    if (responseBody != null) {
                        campaigns.postValue(responseBody.values)
                    }
                } else {
                    stringError.postValue(response.body()?.message)
                }
            }

            override fun onFailure(call: Call<CampaignCallResponse>, t: Throwable) {
                isLoading.postValue(false)
                stringError.postValue(t.message)
                Log.e(TAG, t.message.toString())
                t.printStackTrace()
            }
        })
    }
    companion object{
        val TAG: String = CampaignViewModel::class.java.simpleName
    }
}