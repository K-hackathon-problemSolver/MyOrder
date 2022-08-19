package com.problemsolver.myorder.app.presentation.OrderCheck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.problemsolver.myorder.app.presentation.CustomerOrderCheck.CustomerOrderCheckScreen
import com.problemsolver.myorder.ui.theme.LightGray

@Composable
fun WaitScreen(){
    val scrollState = rememberScrollState()
    
    Column(modifier = Modifier
        .background(color = Color.White)
        .padding(20.dp)
        .verticalScroll(scrollState)) {
        Spacer(modifier = Modifier.height(20.dp))
        CustomOrderWaitLists(listOf(WaitScreenOption()))
    }
}

data class WaitScreenOption(
    val State : String = "주문상태",
    val Name : String = "케이크명",
    val Owner : String = "주문자",
    val Date : String = "주문날짜",
    val Time : String = "주문시간"
)

@Composable
fun ColumnScope.CustomOrderWaitLists(
    options : List<WaitScreenOption>
){
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        options.forEach {
            CustomOrderWaitList(
                optionState = it.State,
                optionName = it.Name,
                optionOwner = it.Owner,
                optionDate = it.Date,
                optionTime = it.Time
            )
        }
    }
}

@Composable
fun ColumnScope.CustomOrderWaitList(
    optionState : String,
    optionName : String,
    optionOwner : String,
    optionDate : String,
    optionTime : String
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .shadow(elevation = 2.dp)
        .padding(10.dp)
    ){
        Column() {
            Text(text = optionState,
                color = LightGray
            )
            Spacer(modifier = Modifier.height(10.dp))
            DevideLine()
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = optionName,
                fontSize = 20.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                Text(text = optionOwner,
                    color = LightGray
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = optionDate,
                    color = LightGray
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = optionTime,
                    color = LightGray
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun DevideLine(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .background(color = Color(0xffB5B5B5)))
}