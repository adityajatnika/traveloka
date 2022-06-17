//package com.traveloka.bestpriceapp.data.remote
//
//import androidx.lifecycle.LiveData
//import androidx.paging.*
//import com.traveloka.bestpriceapp.data.local.room.ProductDatabase
//import com.traveloka.bestpriceapp.data.remote.response.ProductItem
//import com.traveloka.bestpriceapp.data.remote.retrofit.ApiService
//
//class ProductRepository (private val storyDatabase: ProductDatabase, private val apiService: ApiService) {
////    private lateinit var sessionManager: SessionManager
//
//    @OptIn(ExperimentalPagingApi::class)
//    fun getStory(): LiveData<PagingData<ProductItem>> {
////        sessionManager = SessionManager(MainActivity.context)
////        val token = sessionManager.fetchAuthToken().toString()
////        Log.e(this.toString(), "sampai storyrepo")
//        return Pager(
//            config = PagingConfig(
//                pageSize = 10
//            ),
//            remoteMediator = ProductRemoteMediator(storyDatabase, apiService),
//            pagingSourceFactory = {
//                storyDatabase.productDao().getAllProduct()
//            }
//        ).liveData
//    }
//}