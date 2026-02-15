package com.example.dp_lab03.features.fav.viewmodel

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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavVM(private val productsRepo : ProductsRepo) : ViewModel() {

    private val _favState = MutableStateFlow(FavUiState())
    val favState = _favState.asStateFlow()

    init {
        getFavs()
    }

    fun getFavs(){
        viewModelScope.launch {
            _favState.update { it.copy(isLoading = true) }
            _favState.update { it.copy(products = productsRepo.getFavs()) }
            _favState.update { it.copy(isLoading = false) }
        }
    }

    fun deleteFav(productDTO: ProductDTO){
        viewModelScope.launch {
            val rowsDeleted = productsRepo.deleteFav(productDTO)
            if(rowsDeleted > 0){
                _favState.update { it.copy(products = productsRepo.getFavs()) }
                _favState.update { it.copy(msg = "Item deleted successfully") }
            } else {
                _favState.update { it.copy(msg = "Error Could not remove item") }
            }
        }
    }

    fun msgShown(){
        _favState.update { it.copy(msg = null) }
    }

}