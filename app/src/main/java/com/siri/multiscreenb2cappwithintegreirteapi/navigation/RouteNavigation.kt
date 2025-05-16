package com.siri.multiscreenb2cappwithintegreirteapi.navigation

import LoginScreen
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.register.RegisterScreen
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.SplashScreen
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.MainMenuScreen
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.product.ProductDetailsScreen
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.product.ProductViewModel

@Composable
fun RouteNavigation() {
    val navigatorController = rememberNavController()
    val productViewModel: ProductViewModel = hiltViewModel() // Use Hilt to inject ViewModel

    NavHost(navController = navigatorController, startDestination = NavScreens.SplashScreen.route) {
        composable(NavScreens.SplashScreen.route) {
            SplashScreen(navController = navigatorController)
        }
        composable(NavScreens.LoginScreen.route) {
            LoginScreen(navController = navigatorController)
        }
        composable(NavScreens.RegisterScreen.route) {
            RegisterScreen(navController = navigatorController)
        }
        composable(NavScreens.MainMenuScreen.route) {
            MainMenuScreen(navController = navigatorController)
        }

    }

//    NavHost(navController = navigatorController ,
//            startDestination = NavScreens.SplashScreen.name){
//        composable(NavScreens.SplashScreen.name) {
//            SplashScreen(navController = navigatorController)
//        }
//
//        composable(NavScreens.LoginScreen.name) {
//            LoginScreen(navController = navigatorController)
//        }
//
//        composable(NavScreens.RegisterScreen.name) {
//            RegisterScreen(navController = navigatorController)
//        }
//
//        composable(NavScreens.MainMenuScreen.name) {
//            MainMenuScreen(navController = navigatorController)
//        }
//
//        /// Route ของ ProductDetails ให้รับ Argument
//        composable(
//            route = "${NavScreens.ProductDetails.name}/{productJson}",
//            arguments = listOf(navArgument("productJson") {
//                type = NavType.StringType
//            })
//        ) { backStackEntry ->
//            val json = backStackEntry.arguments?.getString("productJson")
//            val product = remember { Gson().fromJson(json, Product::class.java) }
//
//            ProductDetails(navController = navigatorController, product = product)
//        }
//    }


}