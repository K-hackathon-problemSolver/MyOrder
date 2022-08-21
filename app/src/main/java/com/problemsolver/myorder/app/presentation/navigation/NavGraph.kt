package com.problemsolver.myorder.app.presentation.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.unit.sp
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.problemsolver.myorder.app.presentation.BossCustomerSelect.BossCustomerSelectScreen
import com.problemsolver.myorder.app.presentation.CustomerOrderAlarm.CustomerOrderAlarmAcceptScreen
import com.problemsolver.myorder.app.presentation.CustomerOrderCheck.CustomerOrderCheckScreen
import com.problemsolver.myorder.app.presentation.OrderCheck.OrderCheckScreen
import com.problemsolver.myorder.app.presentation.OrderChoiceCustom.OrderChoiceCustomScreen
import com.problemsolver.myorder.app.presentation.SplashScreen
import com.problemsolver.myorder.app.presentation.StoreDetail.BossStoreDetailScreen
import com.problemsolver.myorder.app.presentation.StoreDetail.StoreDetailScreen
import com.problemsolver.myorder.app.presentation.StoreList.StoreListScreen

fun NavGraphBuilder.NavGraph(
	navController: NavController,
	upPress: () -> Unit,
	innerPadding: PaddingValues,
	onStoreClick: (String, NavBackStackEntry) -> Unit,
) {
	navigation(
		route = Screen.HomeScreen.route,
		startDestination = Screen.StoreListScreen.route
	) {
		MainNavGraph(
			navController = navController,
			upPress = upPress,
			onStoreClick = onStoreClick
		)
	}
	
	composable(Screen.SelectScreen.route) {
		BossCustomerSelectScreen(navController = navController)
	}

	composable(Screen.OrderWaitingScreen.route) {
		CustomerOrderAlarmAcceptScreen(navController)
	}

	composable(Screen.OrderChoiceCustomScreen.route) {
		OrderChoiceCustomScreen()
	}

	composable(
		"${Screen.StoreDetailScreen.route}/{${DetailDestinationKey.STORE}}",
		arguments = listOf(
			navArgument(DetailDestinationKey.STORE) { type = NavType.StringType }
		)
	) { backStackEntry ->
		val arguments = requireNotNull(backStackEntry.arguments)
		val storeId = arguments.getString(DetailDestinationKey.STORE)

		StoreDetailScreen(navController)
	}
	
	composable(route = Screen.SplashScreen.route) {
		SplashScreen(navController = navController)
	}

}

private fun NavGraphBuilder.MainNavGraph(
	navController: NavController,
	upPress: () -> Unit,
	onStoreClick: (String, NavBackStackEntry) -> Unit
){
	// nav bar routes
	composable(route = Screen.StoreListScreen.route) {
//		StoreListScreen(
//			onStoreClick = { id -> onStoreClick(id, it) }
//		)
		BossStoreDetailScreen(navController)
	}
	composable(route = Screen.ProfileScreen.route) {
		Text("ProfileScreen", fontSize = 48.sp)
	}
	composable(route = Screen.OrderCheckScreen.route) {
		OrderCheckScreen()
//		CustomerOrderCheckScreen()
	}

}