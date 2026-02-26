package com.example.dp_lab03.data.datasources.remote

import com.example.kandroid_lab05.data.model.ProductsResponse
import com.example.kandroid_lab05.data.network.ProductsService
import javax.inject.Inject

class RemoteDSImpl @Inject constructor(private val productsService : ProductsService): RemoteDS {

    override suspend fun getProducts(): ProductsResponse {
        return productsService.getProducts()
    }
}