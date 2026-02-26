package com.example.dp_lab03.data.repo

import android.content.Context
import com.example.dp_lab03.data.datasources.local.LocalDS
import com.example.dp_lab03.data.datasources.local.LocalDSImpl
import com.example.dp_lab03.data.datasources.remote.RemoteDS
import com.example.dp_lab03.data.datasources.remote.RemoteDSImpl
import com.example.kandroid_lab05.data.model.ProductDTO
import kotlinx.coroutines.flow.Flow

class ProductsRepoImpl  constructor(
    private val remoteDS : RemoteDS,
    private val localDS : LocalDS
) : ProductsRepo {




    override suspend fun getAllProducts() : List<ProductDTO> {
        return remoteDS.getProducts().products
    }

    override suspend fun addToFav(productDTO: ProductDTO) : Boolean{
        return localDS.addToFav(productDTO) > -1
    }

    override fun getFavs(): Flow<List<ProductDTO>>{
        return localDS.getFavs()
    }

    override suspend fun deleteFav(productDTO: ProductDTO) : Int{
        return localDS.deleteFav(productDTO)
    }
}