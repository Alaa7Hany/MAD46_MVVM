package com.example.dp_lab03.data.datasources.remote

import com.example.kandroid_lab05.data.model.ProductsResponse

interface RemoteDS {
    suspend fun getProducts() : ProductsResponse
}