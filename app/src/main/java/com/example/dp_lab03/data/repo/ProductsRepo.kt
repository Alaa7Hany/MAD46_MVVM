package com.example.dp_lab03.data.repo

import com.example.kandroid_lab05.data.model.ProductDTO

interface ProductsRepo {
    suspend fun getAllProducts() : List<ProductDTO>

    suspend fun getFavs() : List<ProductDTO>

    suspend fun addToFav(productDTO: ProductDTO) : Boolean

    suspend fun deleteFav(productDTO: ProductDTO) : Int
}