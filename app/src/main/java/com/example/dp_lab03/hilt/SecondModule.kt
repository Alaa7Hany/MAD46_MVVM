package com.example.dp_lab03.hilt

import com.example.dp_lab03.data.datasources.local.LocalDS
import com.example.dp_lab03.data.datasources.local.LocalDSImpl
import com.example.dp_lab03.data.datasources.remote.RemoteDS
import com.example.dp_lab03.data.datasources.remote.RemoteDSImpl
import com.example.dp_lab03.data.repo.ProductsRepo
import com.example.dp_lab03.data.repo.ProductsRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SecondModule{
    @Binds
    abstract fun blindLocalDS(localDSImpl: LocalDSImpl) : LocalDS
    @Binds
    abstract fun bindRemoteDS(remoteDSImpl: RemoteDSImpl) : RemoteDS
    @Binds
    @Singleton
    abstract fun bindProductsRepo(productsRepoImpl: ProductsRepoImpl) : ProductsRepo

}