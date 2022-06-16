package com.traveloka.bestpriceapp.ui.campaign.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.traveloka.bestpriceapp.data.remote.response.PromoCallResponse
import com.traveloka.bestpriceapp.data.remote.response.PromoItem
import com.traveloka.bestpriceapp.data.remote.response.PromoResponse
import com.traveloka.bestpriceapp.data.remote.retrofit.ApiConfig
import com.traveloka.bestpriceapp.ui.voucher.viewmodel.VoucherViewModel.Companion.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPromoViewModel () {


    val isLoading = MutableLiveData(true)
    val stringError = MutableLiveData<String>()
    val Promo = MutableLiveData<List<PromoItem>>()

    fun getListPromo() {
        isLoading.postValue(true)
        val client = ApiConfig.getApiService().getPromos()
        client.enqueue(object : Callback<PromoResponse> {
            override fun onResponse(
                call: Call<PromoResponse>,
                response: Response<PromoResponse>,
            ) {
                isLoading.postValue(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        Promo.postValue(responseBody.values)
                    }
                } else {
                    stringError.postValue(response.body()?.message)
                }
            }

            override fun onFailure(call: Call<PromoResponse>, t: Throwable) {
                isLoading.postValue(false)
                stringError.postValue(t.message)
                Log.e(TAG, t.message.toString())
//                t.printStackTrace() v
            }
        })
    }
    companion object {
        val TAG: String = ListPromoViewModel::class.java.simpleName
    }
}