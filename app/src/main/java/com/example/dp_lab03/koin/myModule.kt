package com.example.dp_lab03.koin

import com.example.dp_lab03.data.datasources.local.LocalDS
import com.example.dp_lab03.data.datasources.local.LocalDSImpl
import com.example.dp_lab03.data.datasources.remote.RemoteDS
import com.example.dp_lab03.data.datasources.remote.RemoteDSImpl
import com.example.dp_lab03.data.repo.ProductsRepo
import com.example.dp_lab03.data.repo.ProductsRepoImpl
import com.example.dp_lab03.features.fav.viewmodel.FavVM
import com.example.dp_lab03.features.products.viewmodel.AllProductsVM
import com.example.kandroid_lab05.data.db.ProductsDAO
import com.example.kandroid_lab05.data.db.ProductsDB
import com.example.kandroid_lab05.data.network.ProductsService
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val myModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ProductsService> {
        get<Retrofit>().create(ProductsService::class.java)
    }

    single<ProductsRepo> {
        ProductsRepoImpl(get(), get())
    }

    factory<RemoteDS> { RemoteDSImpl(get()) }

    factory<LocalDS> { LocalDSImpl(get() ) }

    single<ProductsDB>{ ProductsDB.getInstance(androidContext()) }

    single<ProductsDAO> { get<ProductsDB>().getProductsDAO() }

    viewModel<AllProductsVM> { AllProductsVM(get()) }

    viewModel<FavVM> { FavVM(get ()) }
}