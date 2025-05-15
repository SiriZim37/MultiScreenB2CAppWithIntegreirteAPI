package com.siri.multiscreenb2cappwithintegreirteapi.navigation

sealed class BottomNavScreens (
    val route: String ,
    val title: String,
    val icon: Int? =null
){
    object  Home: BottomNavScreens(route = "home", title = "Home" , icon = null)
    object  Orders: BottomNavScreens(route = "orders", title = "Orders" , icon = null)
    object  Cart: BottomNavScreens(route = "cart", title = "Cart" , icon = null)
    object  Profile: BottomNavScreens(route = "profile", title = "Profile" , icon = null)
    object  Search: BottomNavScreens(route = "searchScreen", title = "SearchScreen" , icon = null)


    object Items{
        val list = listOf(
            Home , Orders , Cart , Profile
        )
    }
}

