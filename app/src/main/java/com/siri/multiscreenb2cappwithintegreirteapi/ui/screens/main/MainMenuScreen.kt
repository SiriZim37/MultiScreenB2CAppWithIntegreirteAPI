package com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.rememberNavController
import com.siri.multiscreenb2cappwithintegreirteapi.navigation.BottomNavItem
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screen.main.cart.CartScreen
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screen.main.category.CategoryScreen
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screen.main.fav.FavoriteScreen
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screen.main.home.HomeScreen


@Composable
fun MainMenuScreen(navController : NavController) {
    val navController = rememberNavController()
    val items = listOf(BottomNavItem.Home, BottomNavItem.Category, BottomNavItem.Cart, BottomNavItem.Favorite)

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry = navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry.value?.destination?.route

                items.forEach { item ->
                    NavigationBarItem(
                        icon = item.icon,
                        label = { Text(item.label) },
                        selected = currentRoute == item.route,
                        onClick = {
                            if (currentRoute != item.route) {
                                navController.navigate(item.route) {
                                    launchSingleTop = true
                                    restoreState = true
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Home.route) { HomeScreen() }
            composable(BottomNavItem.Category.route) { CategoryScreen() }
            composable(BottomNavItem.Cart.route) { CartScreen() }
            composable(BottomNavItem.Favorite.route) { FavoriteScreen() }
        }
    }
}


