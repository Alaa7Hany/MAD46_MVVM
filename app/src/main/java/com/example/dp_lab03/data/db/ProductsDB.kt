package com.example.kandroid_lab05.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kandroid_lab05.data.model.ProductDTO

@Database(entities = [ProductDTO::class], version = 1)
abstract class ProductsDB : RoomDatabase() {
    abstract fun getProductsDAO() : ProductsDAO

    companion object{
        @Volatile
        private var INSTANCE : ProductsDB? = null

        fun getInstance(context: Context) : ProductsDB{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductsDB::class.java,
                    "products_db"
                ).build()
                INSTANCE = instance
                instance
            }

        }
    }
}