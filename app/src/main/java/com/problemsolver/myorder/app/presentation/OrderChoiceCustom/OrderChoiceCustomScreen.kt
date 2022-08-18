package com.problemsolver.myorder.app.presentation.OrderChoiceCustom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OrderChoiceCustomScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {

        CustomTopBar()
        CustomBody()

    }
}

@Composable
fun ColumnScope.CustomTopBar(){
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
            text = "주문서 수정",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        TextButton(modifier = Modifier.weight(2f),
            onClick = { /*TODO*/ }) {
            Text(text = "적용",
                color = Color.Black)
        }
    }
    Spacer(modifier = Modifier.height(50.dp))
}

@Composable
fun ColumnScope.CustomBody(){
    
}

@Preview
@Composable
fun prqwe(){
    OrderChoiceCustomScreen()
}