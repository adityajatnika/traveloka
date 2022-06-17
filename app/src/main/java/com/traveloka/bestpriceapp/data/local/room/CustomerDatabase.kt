package com.traveloka.bestpriceapp.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.traveloka.bestpriceapp.data.local.entity.RemoteKeys
import com.traveloka.bestpriceapp.data.remote.response.CustomerItem
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [CustomerItem::class, RemoteKeys::class],
    version = 2,
    exportSchema = false
)

abstract class CustomerDatabase : RoomDatabase() {

    abstract fun  CustomerDao(): CustomerDao
    abstract fun remoteKeysDao(): RemoteKeysDao

    companion object{
        @Volatile
        private var INSTANCE: CustomerDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): CustomerDatabase {
            if (INSTANCE == null) {
                kotlin.synchronized(CustomerDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        CustomerDatabase::class.java, "customer_database")
                        .build()
                }
            }
            return INSTANCE as CustomerDatabase
        }
    }
}