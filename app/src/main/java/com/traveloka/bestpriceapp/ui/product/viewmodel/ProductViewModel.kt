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

//    private fun setListUser(userResponses: List<UserResponse>) {
//        val listUser = ArrayList<User>()
//        for (user in userResponses) {
//            listUser.add(
//                User(user.id.toString(), user.login, user.avatarUrl)
//            )
//        }
//        products.postValue(listUser)
//    }

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
//                        setListUser(responseBody.values)
                        products.postValue(responseBody.values)
                    }
                } else {
//                    val msg = if(response.body()?.message)
//                    val errorMessage = when (val statusCode = response.code()) {
//                        ResponseStatus.BAD_REQUEST.stat -> "$statusCode : Bad Request"
//                        ResponseStatus.FORBIDDEN.stat -> "$statusCode : Forbidden"
//                        ResponseStatus.NOT_FOUND.stat -> "$statusCode : Not Found"
//                        else -> "$statusCode"
//                    }
                    stringError.postValue(response.body()?.message)
//                    Log.e(MainViewModel.TAG, errorMessage)
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
    }

}
