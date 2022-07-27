package com.problemsolver.myorder.app.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

enum class BottomSections(
    val title: String,
    val icon: ImageVector,
    val route: String,
) {
    HISTORY("D/VIDE", Icons.Default.ReceiptLong, "home/orderCheck"),
    HOME("REVIEW", Icons.Default.Home, "home/storeList"),
    PROFILE("MyPage", Icons.Default.Person, "home/profile"),
}

@Composable
fun BottomNavBar(
    tabs: Array<BottomSections>,
    currentRoute: String,
    navController: NavController,
) {
    BottomNavigation(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .shadow(elevation = 10.dp),
        backgroundColor = Color.White
    ) {
        tabs.forEach {
            BottomNavigationItem(
                selected = it.route == currentRoute,
                icon = {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = it.icon,
                        contentDescription = it.title,
                        tint = Color.Gray
                    )
                },
                onClick = {
                    navController.navigate(it.route)
                }
            )
        }
    }
}

@Preview
@Composable
fun BottomNavBarPreview() {
    BottomNavBar(
        tabs = BottomSections.values(),
        currentRoute = "home/storeList",
        navController = rememberNavController()
    )
}