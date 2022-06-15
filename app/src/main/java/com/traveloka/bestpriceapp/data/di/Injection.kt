//package com.traveloka.bestpriceapp.data.di
//
//import android.content.Context
//import com.traveloka.bestpriceapp.data.local.room.ProductDatabase
//import com.traveloka.bestpriceapp.data.remote.ProductRepository
//import com.traveloka.bestpriceapp.data.remote.retrofit.ApiConfig
//
//
//object Injection {
//    fun provideRepository(context: Context): ProductRepository {
//        val database = ProductDatabase.getDatabase(context)
//        val apiService = ApiConfig.getApiService()
//        return ProductRepository(database, apiService)
//    }
//}
