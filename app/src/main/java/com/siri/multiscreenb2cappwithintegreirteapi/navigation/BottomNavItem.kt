package com.siri.multiscreenb2cappwithintegreirteapi.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*


sealed class BottomNavItem(
    val route: String,
    val icon: @Composable () -> Unit,
    val label: String
) {
    object Home : BottomNavItem("home", { Icon(Icons.Default.Home, contentDescription = "Home") }, "Home")
    object Category : BottomNavItem("category", { Icon(Icons.Default.List, contentDescription = "Category") }, "Category")
    object Cart : BottomNavItem("cart", { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") }, "Cart")
    object Favorite : BottomNavItem("favorite", { Icon(Icons.Default.Favorite, contentDescription = "Favorite") }, "Favorite")
}