package com.example.dp_lab03.data.datasources.local

import com.example.kandroid_lab05.data.model.ProductDTO
import kotlinx.coroutines.flow.Flow

interface LocalDS {
    suspend fun addToFav(productDTO: ProductDTO) : Long

    fun getFavs() : Flow<List<ProductDTO>>

    suspend fun deleteFav(productDTO: ProductDTO) : Int
}