package com.example.dp_lab03.features.products.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dp_lab03.data.repo.ProductsRepo

class ProductsVMFactory(private val repo: ProductsRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AllProductsVM::class.java)){
            return AllProductsVM(repo) as T
        }
        throw IllegalArgumentException("Unknown vm class")
    }
}