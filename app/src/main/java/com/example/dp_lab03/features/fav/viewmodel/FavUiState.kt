package com.example.dp_lab03.features.fav.viewmodel

import com.example.kandroid_lab05.data.model.ProductDTO

data class FavUiState(
    val products : List<ProductDTO> = emptyList(),
    val isLoading : Boolean = false,
    val error : String? = null,
    val msg : String? = null
)
