package com.example.dp_lab03.features.products.viewmodel

import com.example.kandroid_lab05.data.model.ProductDTO

data class ProductsState(
    val products : List<ProductDTO> = emptyList(),
    val isLoading : Boolean = false,
    val error : String? = null,
    val msg : String? = null
)
