package com.siri.multiscreenb2cappwithintegreirteapi.navigation

//enum class NavScreens {
//    SplashScreen,
//    RegisterScreen,
//    LoginScreen,
//    MainMenuScreen,
//    ProductDetails;
//}

enum class NavScreens(val route: String) {
    SplashScreen("SplashScreen"),
    RegisterScreen("RegisterScreen"),
    LoginScreen("LoginScreen"),
    MainMenuScreen("MainMenuScreen"),
    ProductDetails("ProductDetails") // <-- ชื่อตรงกับ route ใน NavHost ชื่อเส้นทาง (route name) ที่เราจะใช้ใน NavHost กับ navController.navigate()
}
//
//sealed class NavScreens(val route: String) {
//    object SplashScreen : NavScreens("SplashScreen")
//    object LoginScreen : NavScreens("LoginScreen")
//    object RegisterScreen : NavScreens("RegisterScreen")
//    object MainMenuScreen : NavScreens("MainMenuScreen")
//    object ProductDetails : NavScreens("ProductDetailsScreen/{productId}") {
//        fun createRoute(productId: String): String = "ProductDetailsScreen/$productId"
//    }
//}