package com.problemsolver.myorder.app.presentation.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.unit.sp
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.problemsolver.myorder.app.presentation.OrderCheck.OrderCheckScreen
import com.problemsolver.myorder.app.presentation.SplashScreen
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

	composable(route = Screen.SplashScreen.route) {
		SplashScreen(navController = navController)
	}

	composable(
		"${Screen.StoreDetailScreen.route}/{${DetailDestinationKey.STORE}}",
		arguments = listOf(
			navArgument(DetailDestinationKey.STORE) { type = NavType.StringType }
		)
	) { backStackEntry ->
		val arguments = requireNotNull(backStackEntry.arguments)
		val storeId = arguments.getString(DetailDestinationKey.STORE)

		StoreDetailScreen()
	}
}

private fun NavGraphBuilder.MainNavGraph(
	navController: NavController,
	upPress: () -> Unit,
	onStoreClick: (String, NavBackStackEntry) -> Unit
){
	// nav bar routes
	composable(route = Screen.StoreListScreen.route) {
		StoreListScreen(
			onStoreClick = { id -> onStoreClick(id, it) }
		)
	}
	composable(route = Screen.ProfileScreen.route) {
		Text("ProfileScreen", fontSize = 48.sp)
	}
	composable(route = Screen.OrderCheckScreen.route) {
		OrderCheckScreen()
	}

}