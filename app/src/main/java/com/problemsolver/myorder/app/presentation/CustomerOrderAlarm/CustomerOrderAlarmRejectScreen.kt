package com.problemsolver.myorder.app.presentation.CustomerOrderAlarm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.problemsolver.myorder.R

@Composable
fun CustomerOrderAlarmRejectScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        Alarmheader1()
        AlarmBody1()
        AlarmButton1()
    }
}

@Composable
fun ColumnScope.Alarmheader1(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 20.dp)
        .weight(1f),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "주문 완료",
            fontSize = 15.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color(0xffCDCDCD)))
    }
}

@Composable
fun ColumnScope.AlarmBody1(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 50.dp)
        .weight(7f),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(80.dp))
        Text(text = "주문 취소",
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "가게에서 주문을 반려하였습니다.",
            fontSize = 18.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "사장님이 '픽업날짜 수정을 요청했습니다.",
            fontSize = 15.sp,
            color = Color(0xff5F5F5F)
        )
        Text(text = "주문서를 확인하고 재주문 부탁드립니다!",
            fontSize = 15.sp,
            color = Color(0xff5F5F5F)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Image(modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.box_reject),
            contentDescription = "Acceptd Box Picture")
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun ColumnScope.AlarmButton1(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
        .weight(2f)) {
        Button(modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff78C3FA)),
            onClick = { /*TODO*/ }) {
            Text(text = "재주문하기",
                color = Color.White)
        }

        Button(modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            onClick = { /*TODO*/ }) {
            Text(text = "홈화면 돌아가기",
                color = Color(0xff78C3FA)
            )
        }
    }
}

@Preview
@Composable
fun przxvc(){
    CustomerOrderAlarmRejectScreen()
}