package com.problemsolver.myorder.app.presentation.CustomerOrderChoice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.CameraFront
import androidx.compose.material.icons.filled.FileOpen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.problemsolver.myorder.R

@Composable
fun CustomerOrderChoiceScreen(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)) {
        OrderChoiceHeader()
        OrderChoiceCallender()
        OrderChoiceOptions()
        FloatingOrderBar()
    }
}
@Composable
fun ColumnScope.OrderChoiceHeader(){
Row(modifier = Modifier
    .fillMaxWidth()
    .padding(20.dp),
horizontalArrangement = Arrangement.SpaceBetween) {
Text(text = "주문 가능 날짜")
Text(text = "년/월 선택기능▼")
}
}

@Composable
fun ColumnScope.OrderChoiceCallender(){

}

@Composable
fun ColumnScope.OrderChoiceOptions(){

    val scrollstate = rememberScrollState()

Column(modifier = Modifier
    .fillMaxWidth()
    .height(350.dp)
    .verticalScroll(scrollstate)
    .padding(20.dp)) {
OrderChoiceDetail(
    optionName = "시트선택", optionDetail1 = "기본맛(커스터드)", optionPrice1 = "6,900원", optionDetail2 = "크림치즈", optionPrice2 = "7,900원", optionDetail3 = "버터크림", optionPrice3 = "7,900원"
)
    DevideLine()
    OrderChoiceDetail(
        optionName = "모양선택", optionDetail1 = "원형", optionPrice1 = "6,900원", optionDetail2 = "사각형", optionPrice2 = "7,900원", optionDetail3 = "하트", optionPrice3 = "7,900원"
    )
    DevideLine()
    OrderChoiceDetail(
        optionName = "사이즈선택", optionDetail1 = "1호", optionPrice1 = "6,900원", optionDetail2 = "2호", optionPrice2 = "7,900원", optionDetail3 = "3호", optionPrice3 = "7,900원"
    )
    DevideLine()
    Column(modifier = Modifier.fillMaxWidth()) {

        val textState = remember{
            mutableStateOf("")
        }

        Text(text = "요청사항")
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = textState.value,
            onValueChange = { textValue -> textState.value = textValue })
        Spacer(modifier = Modifier.height(20.dp))
    }
    DevideLine()
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "이미지첨부")
        Box(modifier = Modifier.fillMaxWidth()){
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Button(modifier = Modifier.weight(1f),onClick = { /* Do something! */ }, colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.White,
                )) {
                    Icon(painter = painterResource(id = R.drawable.camera), contentDescription ="take picture", tint = Color.LightGray)
                }
                Button(modifier = Modifier.weight(1f),onClick = { /* Do something! */ }, colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.White
                )) {
                    Icon(painter = painterResource(id = R.drawable.file_upload), contentDescription ="file upload", tint = Color.LightGray)
                }
            }
        }
    }
}
}

@Composable
fun OrderChoiceDetail(
    optionName : String,
    optionDetail1 : String,
    optionPrice1: String,
    optionDetail2 : String,
    optionPrice2 : String,
    optionDetail3 : String,
    optionPrice3 : String
){

    Column(modifier = Modifier
        .fillMaxWidth()) {
        Row(modifier = Modifier
            .fillMaxWidth()
        ) {
            Text(text = optionName)
        }
        OrderChoiceDetailBody(optionDetail = optionDetail1, optionPrice = optionPrice1)
        OrderChoiceDetailBody(optionDetail = optionDetail2, optionPrice = optionPrice2)
        OrderChoiceDetailBody(optionDetail = optionDetail3, optionPrice = optionPrice3)
    }
}

@Composable
fun OrderChoiceDetailBody(optionDetail : String,
                          optionPrice : String){

    val checkedState = remember { mutableStateOf(false) }

    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
            Text(text = optionDetail)
        }
        Text(text = optionPrice)
    }

}
@Composable
fun ColumnScope.FloatingOrderBar(){
       Box(modifier = Modifier
           .fillMaxWidth()
           .padding(20.dp),
       contentAlignment = Alignment.Center){
           Button(modifier = Modifier.fillMaxWidth(),
               onClick = { /*TODO*/ },
               colors = ButtonDefaults.buttonColors(
                   backgroundColor = Color(0xff78C3FA))) {
               Text(text = "11,900원 주문하기",
               color = Color.White)
           }
       }
}


@Composable
fun ColumnScope.DevideLine(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .background(Color(0xff78BBFA)))
    Spacer(modifier = Modifier.height(10.dp))
}

@Preview
@Composable
fun previewsomething(){
    CustomerOrderChoiceScreen()
}