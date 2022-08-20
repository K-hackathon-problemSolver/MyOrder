package com.problemsolver.myorder.app.presentation.OrderCheck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.problemsolver.myorder.app._enums.OrderType
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OrderCheckScreen(
    viewModel: OrderCheckViewModel = hiltViewModel()
){

    var tapPage by remember { mutableStateOf(TabPage.접수대기)}
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Scaffold(topBar = {
            TopTab(
            selectedTabIndex = pagerState.currentPage,
            onSelectedTab = {
                scope.launch {
                    pagerState.animateScrollToPage(it.ordinal)
                }
            })
        }) {
                HorizontalPager(
                    count = TabPage.values().size,
                    state = pagerState
                ) { index ->
                    Column(modifier = Modifier.fillMaxSize()) {
                        when (index) {
                            0 -> { WaitScreen() }
                            1 -> { AcceptScreen() }
                            2 -> { RejectScreen() }
                            3 -> { CompleteScreen() }
                        }
                    }
                }
        }
    }
}

enum class TabPage(val pageName: String){
    접수대기("wait"),
    수락("accept"),
    거절("reject"),
    완료("complete")

}

@Composable
fun TopTab(
    selectedTabIndex:Int,
    onSelectedTab : (TabPage) -> Unit
){
    TabRow(selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.White) {
        TabPage.values().forEachIndexed { index, tabPage ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = { onSelectedTab(tabPage) },
                text = { Text(text = tabPage.name)},
                selectedContentColor = Color.Black,
                unselectedContentColor = Color(0xffBBBBBB)
            )
        }
    }
}

//@Preview
//@Composable
//fun prqsss(){
//    OrderCheckScreen()
//}