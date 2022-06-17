package com.traveloka.bestpriceapp.ui.customer.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.traveloka.bestpriceapp.data.remote.response.*
import com.traveloka.bestpriceapp.data.remote.retrofit.ApiConfig
import com.traveloka.bestpriceapp.ui.voucher.viewmodel.VoucherViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VocherViewModel : ViewModel() {

    val isLoading = MutableLiveData(true)
    val stringError = MutableLiveData<String>()
    val voucher = MutableLiveData<List<VoucherItem>>()

    fun getListVoucher() {
        isLoading.postValue(true)
        val client = ApiConfig.getApiService().getVouchers()
        client.enqueue(object : Callback<VoucherCallResponse> {
            override fun onResponse(
                call: Call<VoucherCallResponse>,
                response: Response<VoucherCallResponse>
            ) {
                isLoading.postValue(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        voucher.postValue(responseBody.values)
                    }
                } else {
                    stringError.postValue(response.body()?.message)
                }
            }
            override fun onFailure(call: Call<VoucherCallResponse>, t: Throwable) {
                isLoading.postValue(false)
                stringError.postValue(t.message)
                Log.e(TAG, t.message.toString())
                t.printStackTrace()
            }
        })
    }
    companion object {
        val TAG: String = VoucherViewModel::class.java.simpleName
    }

}
