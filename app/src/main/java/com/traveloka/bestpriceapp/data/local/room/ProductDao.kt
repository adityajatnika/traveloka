//package com.traveloka.bestpriceapp.data.local.room
//
//import androidx.paging.PagingSource
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.traveloka.bestpriceapp.data.remote.response.ProductItem
//
//@Dao
//interface ProductDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertStory(quote: List<ProductItem>)
//
//    @Query("SELECT * FROM product")
//    fun getAllProduct(): PagingSource<Int, ProductItem>
//
//    @Query("DELETE FROM story")
//    suspend fun deleteAll()
//}