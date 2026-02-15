package com.example.dp_lab03.features.home.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dp_lab03.core.nav.ScreensRoutes

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navToAllProducts: () -> Unit,
    navToFav: () -> Unit
) {
    HomeContent(modifier, navToAllProducts, navToFav)
}

@Composable
private fun HomeContent(
    modifier: Modifier = Modifier,
    navToAllProducts: () -> Unit,
    navToFav: () -> Unit
){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(navToAllProducts) {
            Text("All Products")
        }

        Button(navToFav) {
            Text("Favorites")
        }
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen(navToAllProducts = {}, navToFav = {})
}