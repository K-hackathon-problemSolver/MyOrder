package com.problemsolver.myorder.app.presentation.StoreDayOff

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StoreDayOffScreen(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = Color.White)) {
        
        OffDayTopBar()
        OffDayCalender()
        
    }
}

@Composable
fun ColumnScope.OffDayTopBar(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically) {
        TextButton(modifier = Modifier.weight(2f),
            onClick = { /*TODO*/ }) {
            Text(text = "취소",
                color = Color.Black)
        }
        Text(modifier = Modifier.weight(8f),
            textAlign = TextAlign.Center,
            text = "휴무일설정",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        TextButton(modifier = Modifier.weight(2f),
            onClick = { /*TODO*/ }) {
            Text(text = "적용",
                color = Color.Black)
        }
    }
    Spacer(modifier = Modifier.height(100.dp))
}

@Composable
fun ColumnScope.OffDayCalender(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
        .height(200.dp)
        .background(color = Color.LightGray)){
        Text(text = "달력들어갈곳")
    }
}


@Preview
@Composable
fun PreMan(){
    StoreDayOffScreen()
}