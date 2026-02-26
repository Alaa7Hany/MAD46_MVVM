package com.example.dp_lab03.features.products.views

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.dp_lab03.data.repo.ProductsRepo
import com.example.dp_lab03.data.repo.ProductsRepoImpl
import com.example.dp_lab03.features.products.viewmodel.AllProductsVM
import com.example.kandroid_lab05.data.model.ProductDTO
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

@Composable
fun AllProductsScreen(
    viewModel: AllProductsVM = koinViewModel(),
) {
    val context = LocalContext.current
    val productsState by viewModel.productsState.collectAsStateWithLifecycle()

    LaunchedEffect(productsState.msg) {
        productsState.msg?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            viewModel.msgShow()
        }
    }
    AllProductsContents(
        products =  productsState.products,
        isLoading = productsState.isLoading,
        error = productsState.error
    ) { viewModel.addToFav(it) }
}


@Composable
private fun AllProductsContents(
    products: List<ProductDTO>,
    isLoading: Boolean,
    error: String?,
    addToFav: (ProductDTO) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (products.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(products) { movie ->
                    MovieItem(product = movie) {
                        addToFav(movie)
                    }
                }
            }
        }
        // Loading state
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Error state
        if (error != null) {
            Text(
                text = error,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieItem(product: ProductDTO, addToFav: (ProductDTO) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            GlideImage(
                model = product.thumbnail,
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Column {
                Text(text = product.title ?: "")

                Text(text = "Language: ${product.category}")
                Button(onClick = { addToFav(product) }) {
                    Text(text = "Add Favorite")
                }
            }
        }
    }
}