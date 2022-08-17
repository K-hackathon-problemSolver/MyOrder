package com.problemsolver

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import com.problemsolver.myorder.app.presentation.component.BottomNavBar
import com.problemsolver.myorder.app.presentation.component.MyOrderScaffold
import com.problemsolver.myorder.app.presentation.navigation.NavGraph
import com.problemsolver.myorder.app.presentation.navigation.Screen
import com.problemsolver.myorder.rememberMyOrderAppState
import com.problemsolver.myorder.ui.theme.MyOrderTheme

@Composable
fun MyOrderApp() {
    val appState = rememberMyOrderAppState()

    MyOrderTheme {
        MyOrderScaffold(
            scaffoldState = appState.scaffoldState,
            bottomBar = {
                if(appState.shouldShowBottomBar) {
                    BottomNavBar(tabs = appState.bottomBarTabs,
                        currentRoute = appState.currentRoute!!,
                        navController = appState.navController)
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = appState.navController,
                startDestination = Screen.SplashScreen.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                NavGraph(
                    navController = appState.navController,
                    upPress = appState::upPress,
                    innerPadding = innerPadding,
                    onStoreClick = appState::navigateToStoreDetail
                )
            }
        }
    }
}

@Preview
@Composable
fun MyOrderAppPreview() {
    MyOrderApp()
}