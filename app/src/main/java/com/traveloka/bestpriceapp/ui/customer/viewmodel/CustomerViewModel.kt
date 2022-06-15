package com.traveloka.bestpriceapp.ui.customer.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.traveloka.bestpriceapp.data.remote.Customer
import com.traveloka.bestpriceapp.data.remote.response.CustomerItem
import com.traveloka.bestpriceapp.data.remote.response.CustomerResponse
import com.traveloka.bestpriceapp.data.remote.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CustomerViewModel : ViewModel() {

    val customers = MutableLiveData<List<CustomerItem>>()
    val isLoading = MutableLiveData(true)
    val stringError = MutableLiveData<String>()

    fun getListCustomer() {
        isLoading.postValue(true)
        val client = ApiConfig.getApiService().getCustomers()
        client.enqueue(object : Callback<CustomerResponse>{
            override fun onResponse(
                call: Call<CustomerResponse>,
                response: Response<CustomerResponse>
            ) {
                isLoading.postValue(false)
                if (response.isSuccessful){
                    val responseBody = response.body()
                    if (responseBody != null) {
    //                    setListUser(responseBody.values)
                        customers.postValue(responseBody.values)
                    }
                } else {
//                    val msg = if(response.body()?.message)
//                    val errorMessage = when (val statusCode = response.code()) {
//                        ResponseStatus.BAD_REQUEST.stat -> "$statusCode : Bad Request"
//                        ResponseStatus.FORBIDDEN.stat -> "$statusCode : Forbidden"
//                        ResponseStatus.NOT_FOUND.stat -> "$statusCode : Not Found"
//                        else -> "$statusCode"
//                    }
//                stringError.postValue(response.body()?.message)
//                    Log.e(CustomerViewModel.TAG, errorMessage)
                }
            }

            override fun onFailure(call: Call<CustomerResponse>, t: Throwable) {
                isLoading.postValue(false)
                stringError.postValue(t.message)
                Log.e(TAG, t.message.toString())
                t.printStackTrace()
            }
        })
    }
    companion object {
        val TAG: String = CustomerViewModel::class.java.simpleName
    }
}