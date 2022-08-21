package com.problemsolver.myorder.app.presentation.CustomerOrderAlarm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.problemsolver.myorder.app.presentation.navigation.Screen

@Composable
fun CustomerOrderAlarmAcceptScreen(
    navController: NavController = rememberNavController()
){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        Alarmheader()
        AlarmBody()
        AlarmButton(onClick = { navController.navigate(Screen.HomeScreen.route) { popUpTo(0)} })
    }
}

@Composable
fun ColumnScope.Alarmheader(){
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
fun ColumnScope.AlarmBody(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 50.dp)
        .weight(7f),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(80.dp))
        Text(text = "주문 접수",
        fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "가게에 주문이 접수되었습니다.",
        fontSize = 18.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "픽업 날짜를 정확하게 확인해주세요!",
        fontSize = 15.sp,
        color = Color(0xff5F5F5F))
//        Text(text = "",
//            fontSize = 15.sp,
//            color = Color(0xff5F5F5F))
        Spacer(modifier = Modifier.height(50.dp))
        Image(modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = com.problemsolver.myorder.R.drawable.box_accept),
            contentDescription = "Acceptd Box Picture")
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun ColumnScope.AlarmButton(
    onClick: () -> Unit = {}
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
        .weight(2f)) {
            Button(modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff78C3FA)),
                onClick = onClick
            ) {
                Text(text = "홈화면 돌아가기",
                color = Color.White)
            }

//            Button(modifier = Modifier.fillMaxWidth(),
//                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
//                onClick = { /*TODO*/ }) {
//                Text(text = "홈화면 돌아가기",
//                color = Color(0xff78C3FA))
//            }
    }
}


@Preview
@Composable
fun przxc(){
    CustomerOrderAlarmAcceptScreen()
}