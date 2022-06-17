//package com.traveloka.bestpriceapp.data.remote
//
//import android.util.Log
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.traveloka.bestpriceapp.data.remote.response.ProductItem
//import com.traveloka.bestpriceapp.data.remote.retrofit.ApiService
//import java.lang.StringBuilder
//
//class ProductPagingSource(private val apiService: ApiService, private val token: String) : PagingSource<Int, ProductItem>() {
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductItem> {
//        return try {
//            Log.e(this.toString(), "sampai pagingsource")
//            val position = params.key ?: INITIAL_PAGE_INDEX
//            Log.e(this.toString(), "sampai ayok")
//            val responseData = apiService.getProducts(page = position)
//            val data = responseData.values
//            Log.e(this.toString(), "sesudah")
//
//            LoadResult.Page(
//                data = data,
//                prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
//                nextKey = if (data.isNullOrEmpty()) null else position + 1
//            )
//        } catch (exception: Exception) {
//            return LoadResult.Error(exception)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, ProductItem>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//        }
//    }
//    private companion object {
//        const val INITIAL_PAGE_INDEX = 1
//    }
//}