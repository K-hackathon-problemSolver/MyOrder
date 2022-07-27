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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.problemsolver.myorder.R
import com.problemsolver.myorder.app.presentation.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun NavGraph(
    navController: NavHostController,
    upPress: () -> Unit,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        // nav bar routes
        composable(route = Screen.StoreListScreen.route) {
            Text("StoreListScreen", fontSize = 48.sp)
        }
        composable(route = Screen.ProfileScreen.route) {
            Text("ProfileScreen", fontSize = 48.sp)
        }
        composable(route = Screen.OrderCheckScreen.route) {
            Text("OrderCheckScreen", fontSize = 48.sp)
        }
    }
}