package com.traveloka.bestpriceapp.ui.campaign.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.traveloka.bestpriceapp.data.remote.response.*
import com.traveloka.bestpriceapp.data.remote.retrofit.ApiConfig
import com.traveloka.bestpriceapp.ui.product.activity.AddProductActivity.Companion.toSnakeCase
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastViewModel : ViewModel() {

    val forecast = MutableLiveData<List<Int>>()
    val campaigns = MutableLiveData<List<CampaignItem>>()
    val isLoading = MutableLiveData(true)
    val stringError = MutableLiveData<String>()
    val categoryList = MutableLiveData<String>()

    fun changeActive(id:Int, isActive:Boolean){
        // Create JSON using JSONObject
        val jsonObject = JSONObject()
        jsonObject.put("is_active", !isActive)

        // Convert JSONObject to String
        val jsonObjectString = jsonObject.toString()

        // Create RequestBody ( We're not using any converter, like GsonConverter, MoshiConverter e.t.c, that's why we use RequestBody )
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

        val client = ApiConfig.getApiService().setActive(id, requestBody)
        client.enqueue(object : Callback<CampaignCallResponse> {
            override fun onResponse(
                call: Call<CampaignCallResponse>,
                response: Response<CampaignCallResponse>
            ) {
                isLoading.postValue(false)
                if (response.isSuccessful) {
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

    fun applyCampaigns(){
        val client = ApiConfig.getApiService().applyCampaigns()
        client.enqueue(object : Callback<CampaignCallResponse> {
            override fun onResponse(
                call: Call<CampaignCallResponse>,
                response: Response<CampaignCallResponse>
            ) {
                isLoading.postValue(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        stringError.postValue(responseBody.message)
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

    fun getCampaigns() {
        isLoading.postValue(true)
        val client = ApiConfig.getApiService().getCampaigns()
        client.enqueue(object : Callback<CampaignCallResponse> {
            override fun onResponse(
                call: Call<CampaignCallResponse>,
                response: Response<CampaignCallResponse>
            ) {
                isLoading.postValue(false)
                if (response.isSuccessful) {
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

    fun getForecast() {
        isLoading.postValue(true)
        val client = ApiConfig.getApiService().getForecast()
        client.enqueue(object : Callback<ForecastResponse> {
            override fun onResponse(
                call: Call<ForecastResponse>,
                response: Response<ForecastResponse>
            ) {
                isLoading.postValue(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        forecast.postValue(responseBody.values.auto)
                    }
                } else {
                    stringError.postValue(response.body()?.message)
                }
            }
            override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
                isLoading.postValue(false)
                stringError.postValue(t.message)
                Log.e(TAG, t.message.toString())
                t.printStackTrace()
            }
        })
    }



    companion object {
        val TAG: String = ForecastViewModel::class.java.simpleName
        fun String.toSnakeCase() =
            split(' ').joinToString("_", transform = String::lowercase)
    }
}