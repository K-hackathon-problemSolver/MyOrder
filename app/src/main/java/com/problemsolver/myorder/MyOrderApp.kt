package com.problemsolver

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.problemsolver.myorder.app.presentation.component.BottomNavBar
import com.problemsolver.myorder.app.presentation.component.MyOrderScaffold
import com.problemsolver.myorder.app.presentation.navigation.NavGraph
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
            NavGraph(
                navController = appState.navController,
                upPress = appState::upPress,
                innerPadding = innerPadding
            )
        }
    }
}

@Preview
@Composable
fun MyOrderAppPreview() {
    MyOrderApp()
}