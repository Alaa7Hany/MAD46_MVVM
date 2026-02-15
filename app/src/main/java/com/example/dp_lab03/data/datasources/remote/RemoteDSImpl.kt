package com.example.dp_lab03.data.datasources.remote

import com.example.kandroid_lab05.data.model.ProductsResponse
import com.example.kandroid_lab05.data.network.ProductsService
import com.example.kandroid_lab05.data.network.RetrofitHelper

class RemoteDSImpl private constructor(): RemoteDS {
    private val productsService : ProductsService

    init {
        productsService = RetrofitHelper.retrofitService
    }

    companion object{
        @Volatile
        private var instance : RemoteDSImpl? = null
        fun getInstance() : RemoteDSImpl{
            return instance ?: synchronized(this){
                instance ?: RemoteDSImpl().also { instance = it }
            }
        }
    }

    override suspend fun getProducts(): ProductsResponse {
        return productsService.getProducts()
    }
}