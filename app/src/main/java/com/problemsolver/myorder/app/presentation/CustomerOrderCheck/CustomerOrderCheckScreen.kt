package com.problemsolver.myorder.app.presentation.CustomerOrderCheck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomerOrderCheckScreen(){

    val scrollState = rememberScrollState()

Column(modifier = Modifier
    .background(color = Color.White)
    .padding(20.dp)
    .verticalScroll(scrollState)) {
    Spacer(modifier = Modifier.height(20.dp))
    CustomOrderCheckLists()
}
}

@Composable
fun ColumnScope.CustomOrderCheckLists(
    State : String = "주문상태",
    Name : String = "케이크명",
    Owner : String = "주문자",
    Date : String = "주문날짜",
    Time : String = "주문시간",
){
Column(modifier = Modifier
    .fillMaxWidth()
    ) {
    CustomOrderCheckList(
        optionState = State, optionName = Name, optionOwner = Owner, optionDate = Date, optionTime = Time
    )
    CustomOrderCheckList(
        optionState = State, optionName = Name, optionOwner = Owner, optionDate = Date, optionTime = Time
    )
    CustomOrderCheckList(
        optionState = State, optionName = Name, optionOwner = Owner, optionDate = Date, optionTime = Time
    )
    CustomOrderCheckList(
        optionState = State, optionName = Name, optionOwner = Owner, optionDate = Date, optionTime = Time
    )
}
}

@Composable
fun ColumnScope.CustomOrderCheckList(
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
            color = com.problemsolver.myorder.ui.theme.LightGray)
           Spacer(modifier = Modifier.height(10.dp))
            DevideLine()
           Spacer(modifier = Modifier.height(10.dp))
            Text(text = optionName,
            fontSize = 20.sp)
           Spacer(modifier = Modifier.height(10.dp))
            Row() {
                Text(text = optionOwner,
                    color = com.problemsolver.myorder.ui.theme.LightGray)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = optionDate,
                    color = com.problemsolver.myorder.ui.theme.LightGray)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = optionTime,
                    color = com.problemsolver.myorder.ui.theme.LightGray)
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

@Preview
@Composable
fun pranything(){
    CustomerOrderCheckScreen()
}



