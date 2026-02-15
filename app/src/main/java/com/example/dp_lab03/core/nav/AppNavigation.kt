package com.example.dp_lab03.core.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dp_lab03.features.fav.views.FavScreen
import com.example.dp_lab03.features.home.views.HomeScreen
import com.example.dp_lab03.features.products.views.AllProductsScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    con: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = con,
        startDestination = ScreensRoutes.HomeScreenRoute
    )  {
        composable<ScreensRoutes.HomeScreenRoute>{
            HomeScreen(
                navToAllProducts = { con.navigate(route = ScreensRoutes.ProductsScreenRoute) },
                navToFav = { con.navigate(route = ScreensRoutes.FavScreenRoute) }
            )
        }
        composable<ScreensRoutes.ProductsScreenRoute> {
            AllProductsScreen()
        }
        composable<ScreensRoutes.FavScreenRoute> {
            FavScreen()
        }
    }

}