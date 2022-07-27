package com.problemsolver.myorder.app.presentation.navigation

sealed class Screen(val route: String) {
    object SplashScreen: Screen("splash")
    object StoreListScreen: Screen("home/storeList")
    object ProfileScreen: Screen("home/profile")
    object OrderCheckScreen: Screen("home/orderCheck")
}