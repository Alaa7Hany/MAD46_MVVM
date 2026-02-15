package com.example.kandroid_lab05.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kandroid_lab05.data.model.ProductDTO

@Dao
interface ProductsDAO {
    @Query("SELECT * FROM products")
    suspend fun getProducts() : List<ProductDTO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(products:List<ProductDTO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFav(product: ProductDTO) : Long

    @Query("DELETE FROM products")
    suspend fun deleteAllProducts()

    @Delete
    suspend fun deleteProduct(productDTO: ProductDTO) : Int
}