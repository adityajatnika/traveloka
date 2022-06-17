//package com.traveloka.bestpriceapp.data.local.room
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.traveloka.bestpriceapp.data.remote.response.ProductItem
//
//
//@Database(
//    entities = [ProductItem::class, RemoteKeys::class],
//    version = 2,
//    exportSchema = false
//)
//abstract class ProductDatabase : RoomDatabase() {
//
//    abstract fun productDao(): ProductDao
//    abstract fun remoteKeysDao(): RemoteKeysDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: ProductDatabase? = null
//
//        @JvmStatic
//        fun getDatabase(context: Context): ProductDatabase {
//            return INSTANCE ?: synchronized(this) {
//                INSTANCE ?: Room.databaseBuilder(
//                    context.applicationContext,
//                    ProductDatabase::class.java, "product_database"
//                ).build().apply { INSTANCE = this }
////                    .fallbackToDestructiveMigration()
////                    .build()
////                    .also { INSTANCE = it }
//            }
//        }
//    }
//}