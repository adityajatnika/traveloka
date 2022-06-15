package com.traveloka.bestpriceapp.data.local.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.traveloka.bestpriceapp.data.remote.response.CustomerItem

@Dao
interface CustomerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStory(quote: List<CustomerItem>)

    @Query("SELECT * FROM customer")
    fun getAllCustomer(): PagingSource<Int, CustomerItem>

    @Query("DELETE FROM customer")
    suspend fun deleteAll()

}