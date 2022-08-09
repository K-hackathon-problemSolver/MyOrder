package com.problemsolver.myorder.app.presentation.CustomerOrderCheckDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.problemsolver.myorder.app.presentation.StoreDetail.*

@Composable
fun CustomerOCDScreen (){

    Column(modifier = Modifier
        .background(color = Color.White)
        .padding(20.dp)) {
        CustomerName()
        DevideLine()
        CustomerOrderDetail()
        DevideLine()
        CustomerOrderPrice()
        //닫기 버튼?
    }
}

@Composable
fun ColumnScope.CustomerName(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
    contentAlignment = Alignment.Center){
        Text(text = "진윤정",
        fontSize = 30.sp)
    }
}

@Composable
fun ColumnScope.CustomerOrderDetail(){

    val scrollState = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(270.dp)
        .verticalScroll(scrollState)) {
        OrderDetail(optionName ="주문일시" , optionDetail = "2022-08-09")
        OrderDetail(optionName = "픽업일시", optionDetail = "2022-08-15")
        OrderDetail(optionName = "디자인", optionDetail = "그라데이션")
        OrderDetail(optionName = "시트", optionDetail = "크림치즈")
        OrderDetail(optionName = "모양", optionDetail = "하트")
        OrderDetail(optionName = "사이즈", optionDetail = "1호")
        OrderDetail(optionName = "문구", optionDetail = "축하해")
        OrderDetail(optionName = "요청사항", optionDetail = "문구 크게 써주세요")
        OrderDetail(optionName = "이미지", optionDetail = "")
        //이미지 받아와서 표시
    }
}

@Composable
fun OrderDetail(
    optionName : String,
    optionDetail : String,
){
Row(modifier = Modifier
    .fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween
        ) {
        Text(text = optionName)
        Text(text = optionDetail)
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun ColumnScope.CustomerOrderPrice(){
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = "금액")
        Text(text = "129,000원",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ColumnScope.DevideLine(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(2.dp)
        .background(Color(0xff78BBFA)))
    Spacer(modifier = Modifier.height(20.dp))
}

@Preview
@Composable
fun preODCS(){
    CustomerOCDScreen()
}