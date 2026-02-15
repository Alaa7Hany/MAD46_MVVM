package com.example.dp_lab03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dp_lab03.core.nav.AppNavigation
import com.example.dp_lab03.core.nav.ScreensRoutes
import com.example.dp_lab03.features.fav.views.FavScreen
import com.example.dp_lab03.features.home.views.HomeScreen
import com.example.dp_lab03.features.products.views.AllProductsScreen
import com.example.dp_lab03.ui.theme.DP_lab03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DP_lab03Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(Modifier)
                }
            }
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier) {
    AppNavigation()
}

@Preview(showBackground = true)
@Composable
private fun MainPrev() {
    DP_lab03Theme{
        Main()
    }
}