package com.example.dp_lab03.data.repo

import com.example.kandroid_lab05.data.model.ProductDTO
import kotlinx.coroutines.flow.Flow

interface ProductsRepo {
    suspend fun getAllProducts() : List<ProductDTO>

    fun getFavs() : Flow<List<ProductDTO>>

    suspend fun addToFav(productDTO: ProductDTO) : Boolean

    suspend fun deleteFav(productDTO: ProductDTO) : Int
}