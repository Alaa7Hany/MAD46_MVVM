package com.example.kandroid_lab05.data.network

import com.example.kandroid_lab05.data.model.ProductsResponse
import retrofit2.http.GET

interface ProductsService {
    @GET("products")
    suspend fun getProducts() : ProductsResponse
}