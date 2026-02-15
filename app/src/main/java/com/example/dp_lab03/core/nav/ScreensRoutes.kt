package com.example.dp_lab03.core.nav

import kotlinx.serialization.Serializable

sealed class ScreensRoutes {
    @Serializable
    object ProductsScreenRoute : ScreensRoutes()
    @Serializable
    object FavScreenRoute : ScreensRoutes()
    @Serializable
    object HomeScreenRoute : ScreensRoutes()
}