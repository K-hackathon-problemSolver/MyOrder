package com.problemsolver.myorder.app.presentation.navigation

sealed class Screen(val route: String) {
    object SplashScreen: Screen("splash")
    object HomeScreen: Screen("home")
    object StoreListScreen: Screen("home/storeList")
    object ProfileScreen: Screen("home/profile")
    object OrderCheckScreen: Screen("home/orderCheck")
    object StoreDetailScreen: Screen("store_detail")
    object PostDemandScreen: Screen("post_demand")
    object CustomerOrderCheck: Screen("customer_order_check")
    object OrderCheck: Screen("order_check")
    object SelectScreen: Screen("select_screen")
    object OrderWaitingScreen: Screen("order_waiting_screen")
    object BossStoreDetail: Screen("boss_store_detail")
    object OrderChoiceCustomScreen: Screen("order_choice_customer")

}

object DetailDestinationKey{
    const val STORE = "storeId"
    const val OPTIONS = "optionJson"
}