package com.example.dp_lab03.hilt

import android.content.Context
import com.example.kandroid_lab05.data.db.ProductsDAO
import com.example.kandroid_lab05.data.db.ProductsDB
import com.example.kandroid_lab05.data.network.ProductsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class FirstModuleProvider {
    @Provides
    fun provideRetrofit (): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideProductsService(retrofit: Retrofit) : ProductsService {
        return retrofit.create(ProductsService::class.java)
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ProductsDB{
        return ProductsDB.getInstance(context)
    }

    @Provides
    fun provideProductsDao(db: ProductsDB): ProductsDAO{
        return db.getProductsDAO()
    }

}