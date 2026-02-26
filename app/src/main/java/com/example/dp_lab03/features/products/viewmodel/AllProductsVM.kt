package com.example.dp_lab03.features.products.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dp_lab03.data.repo.ProductsRepo
import com.example.dp_lab03.data.repo.ProductsRepoImpl
import com.example.kandroid_lab05.data.model.ProductDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllProductsVM @Inject constructor
    (private val productsRepo: ProductsRepo): ViewModel() {

    private val _productsState = MutableStateFlow(ProductsState())
    val productsState = _productsState.asStateFlow()

    init {
        getAllProducts()
    }

    fun getAllProducts(){
        viewModelScope.launch {
            _productsState.update{ it.copy(isLoading = true) }
            try {
                val products = productsRepo.getAllProducts()
                _productsState.update{ it.copy(products = products) }
            } catch (e: Exception){
                _productsState.update{ it.copy(error = e.toString()) }
            }
            _productsState.update{ it.copy(isLoading = false) }
        }
    }

    fun addToFav(productDTO: ProductDTO){
        viewModelScope.launch {
            val added = productsRepo.addToFav(productDTO)

            if (added){
                val msg = "Product added to favorites"
                _productsState.update{ it.copy(msg = msg) }
            } else {
                val msg = "something bad happened"
                _productsState.update{ it.copy(msg = msg) }
            }
        }
    }

    fun msgShow(){
        _productsState.update{ it.copy(msg = null) }
    }

}