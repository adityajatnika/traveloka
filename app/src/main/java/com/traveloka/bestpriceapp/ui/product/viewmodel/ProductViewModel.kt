package com.traveloka.bestpriceapp.ui.product.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.traveloka.bestpriceapp.data.remote.response.ProductCallResponse
import com.traveloka.bestpriceapp.data.remote.response.ProductItem
import com.traveloka.bestpriceapp.data.remote.response.ProductResponse
import com.traveloka.bestpriceapp.data.remote.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {

    val products = MutableLiveData<List<ProductItem>>()
    val isLoading = MutableLiveData(true)
    val stringError = MutableLiveData<String>()
    val categoryList = MutableLiveData<String>()

    fun getListProduct() {
        isLoading.postValue(true)
        val client = ApiConfig.getApiService().getProducts()
        client.enqueue(object : Callback<ProductCallResponse> {
            override fun onResponse(
                call: Call<ProductCallResponse>,
                response: Response<ProductCallResponse>
            ) {
                isLoading.postValue(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        products.postValue(responseBody.values)
                    }
                } else {
                    stringError.postValue(response.body()?.message)
                }
            }

            override fun onFailure(call: Call<ProductCallResponse>, t: Throwable) {
                isLoading.postValue(false)
                stringError.postValue(t.message)
                Log.e(TAG, t.message.toString())
                t.printStackTrace()
            }
        })
    }

    fun getListProductSearch(key : String) {
        isLoading.postValue(true)
        val client = ApiConfig.getApiService().getProductsByCategory(key.toSnakeCase())
        Log.e(TAG, key.toSnakeCase())
        client.enqueue(object : Callback<ProductCallResponse> {
            override fun onResponse(
                call: Call<ProductCallResponse>,
                response: Response<ProductCallResponse>
            ) {
                isLoading.postValue(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        products.postValue(responseBody.values)
                    }
                } else {
                    stringError.postValue(response.body()?.message)
                }
            }

            override fun onFailure(call: Call<ProductCallResponse>, t: Throwable) {
                isLoading.postValue(false)
                stringError.postValue(t.message)
                Log.e(TAG, t.message.toString())
                t.printStackTrace()
            }
        })
    }

    companion object {
        val TAG: String = ProductViewModel::class.java.simpleName
        fun String.toSnakeCase() =
            split(' ').joinToString("_", transform = String::lowercase)
    }
}
