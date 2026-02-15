package com.example.dp_lab03.data.repo

import android.content.Context
import com.example.dp_lab03.data.datasources.local.LocalDS
import com.example.dp_lab03.data.datasources.local.LocalDSImpl
import com.example.dp_lab03.data.datasources.remote.RemoteDS
import com.example.dp_lab03.data.datasources.remote.RemoteDSImpl
import com.example.kandroid_lab05.data.model.ProductDTO

class ProductsRepoImpl private constructor(context: Context) : ProductsRepo {
    private val remoteDS : RemoteDS
    private val localDS : LocalDS

    init {
        remoteDS = RemoteDSImpl.getInstance()
        localDS = LocalDSImpl.getInstance(context)
    }

    companion object{
        @Volatile
        private var instance : ProductsRepoImpl? = null
        fun getInstance(context: Context) : ProductsRepoImpl{
            return instance ?: synchronized(this){
                instance ?: ProductsRepoImpl(context).also { instance = it }
            }
        }
    }

    override suspend fun getAllProducts() : List<ProductDTO> {
        return remoteDS.getProducts().products
    }

    override suspend fun addToFav(productDTO: ProductDTO) : Boolean{
        return localDS.addToFav(productDTO) > -1
    }

    override suspend fun getFavs():List<ProductDTO>{
        return localDS.getFavs()
    }

    override suspend fun deleteFav(productDTO: ProductDTO) : Int{
        return localDS.deleteFav(productDTO)
    }
}