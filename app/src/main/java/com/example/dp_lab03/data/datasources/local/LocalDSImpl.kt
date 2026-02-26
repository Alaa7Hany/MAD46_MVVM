package com.example.dp_lab03.data.datasources.local

import android.content.Context
import com.example.kandroid_lab05.data.db.ProductsDAO
import com.example.kandroid_lab05.data.db.ProductsDB
import com.example.kandroid_lab05.data.model.ProductDTO
import kotlinx.coroutines.flow.Flow

class LocalDSImpl private constructor(context: Context) : LocalDS {
    private val productsDAO : ProductsDAO
    init {
        productsDAO = ProductsDB.getInstance(context).getProductsDAO()
    }

    companion object{
        @Volatile
        private var instance : LocalDSImpl? = null
        fun getInstance(context: Context) : LocalDSImpl{
            return instance ?: synchronized(this) {
                instance ?: LocalDSImpl(context).also { instance = it }
            }
        }
    }

    override suspend fun addToFav(product: ProductDTO) : Long{
        return productsDAO.addToFav(product)
    }

    override fun getFavs(): Flow<List<ProductDTO>> {
        return productsDAO.getProducts()
    }

    override suspend fun deleteFav(productDTO: ProductDTO) : Int{
        return productsDAO.deleteProduct(productDTO)
    }

}