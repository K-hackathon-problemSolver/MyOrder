package com.problemsolver.myorder.app.presentation.CustomerOrderCheckDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        Spacer(modifier = Modifier.height(10.dp))
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

    var options = listOf<String>("주문일시","픽업일시","디자인","시트","모양","사이즈","문구","요청사항")
    var detail = listOf<String>("2022-08-09","2022-08-15","그라데이션","크림치즈","하트","1호","축하해","문구 크게 써주세요")

    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 1),
        contentPadding = PaddingValues(top = 20.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        items(options.size){
            OrderDetail(optionName = options[it],
               optionDetail = detail[it] )
        }
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
}

@Preview
@Composable
fun preODCS(){
    CustomerOCDScreen()
}