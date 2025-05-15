package com.siri.multiscreenb2cappwithintegreirteapi.navigation

import LoginScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.register.RegisterScreen
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.SplashScreen
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.MainMenuScreen

@Composable
fun ShopKartNavigation() {
    val navigatorController = rememberNavController()
    NavHost(navController = navigatorController ,
            startDestination = NavScreens.SplashScreen.name){
        composable(NavScreens.SplashScreen.name) {
            SplashScreen(navController = navigatorController)
        }

        composable(NavScreens.LoginScreen.name) {
            LoginScreen(navController = navigatorController)
        }

        composable(NavScreens.RegisterScreen.name) {
            RegisterScreen(navController = navigatorController)
        }

        composable(NavScreens.MainMenuScreen.name) {
            MainMenuScreen(navController = navigatorController)
        }
    }
}