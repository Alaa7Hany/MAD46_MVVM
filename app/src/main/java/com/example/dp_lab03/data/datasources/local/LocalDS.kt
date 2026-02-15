package com.example.dp_lab03.data.datasources.local

import com.example.kandroid_lab05.data.model.ProductDTO

interface LocalDS {
    suspend fun addToFav(productDTO: ProductDTO) : Long

    suspend fun getFavs() : List<ProductDTO>

    suspend fun deleteFav(productDTO: ProductDTO) : Int
}