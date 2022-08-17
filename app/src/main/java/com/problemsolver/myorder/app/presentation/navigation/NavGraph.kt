package com.problemsolver.myorder.app.presentation.navigation

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.problemsolver.myorder.R
import com.problemsolver.myorder.app.presentation.SplashScreen
import com.problemsolver.myorder.app.presentation.StoreDetail.StoreDetailScreen
import com.problemsolver.myorder.app.presentation.StoreDetail.StoreDetailViewModel
import com.problemsolver.myorder.app.presentation.StoreList.StoreListScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun NavGraphBuilder.NavGraph(
	navController: NavController,
	upPress: () -> Unit,
	innerPadding: PaddingValues,
	onStoreClick: (String, NavBackStackEntry) -> Unit
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

		StoreDetailScreen(
			navController = navController,
			upPress = upPress,
			storeId = storeId!!,
		)
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
			navController = navController,
			onStoreClick = { id -> onStoreClick(id, it) }
		)
	}
	composable(route = Screen.ProfileScreen.route) {
		Text("ProfileScreen", fontSize = 48.sp)
	}
	composable(route = Screen.OrderCheckScreen.route) {
		Text("OrderCheckScreen", fontSize = 48.sp)
	}

}