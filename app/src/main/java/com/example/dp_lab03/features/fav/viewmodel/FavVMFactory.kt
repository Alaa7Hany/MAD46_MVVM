package com.example.dp_lab03.features.fav.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dp_lab03.data.repo.ProductsRepo

class FavVMFactory(private val repo: ProductsRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FavVM::class.java)){
            return FavVM(repo) as T
        }
        throw IllegalArgumentException("Unknown vm class")
    }
}