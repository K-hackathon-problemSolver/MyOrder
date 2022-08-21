package com.problemsolver.myorder.app.presentation.OrderCheck

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.problemsolver.myorder.app.presentation.CustomerOrderCheck.CustomOrderCheckList
import com.problemsolver.myorder.app.presentation.CustomerOrderCheck.CustomerOrderCheckScreen
import com.problemsolver.myorder.app.presentation.CustomerOrderCheckDetail.CustomerOCDScreen
import com.problemsolver.myorder.ui.theme.LightGray

@Composable
fun WaitScreen(){

    val scrollState = rememberScrollState()
    val isVisible = remember { mutableStateOf(false) }
    val isVisible2 = remember { mutableStateOf(true) }
    val mContext = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .background(color = Color.White)
                .padding(20.dp)
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            if(isVisible2.value) {
                CustomOrderCheckList(
                    color = "black",
                    optionState = "접수대기",
                    optionName = "3단 트리플 케이크",
                    optionOwner = "진윤정",
                    optionDate = "2022.08.21",
                    optionTime = "19:34",
                    onClick = { isVisible.value = true }
                )
            }
            CustomOrderCheckList(
                color = "black",
                optionState = "접수대기",
                optionName = "시그니처 케이크",
                optionOwner = "홍유준",
                optionDate = "2022.08.22",
                optionTime = "11:34",
                onClick = { }
            )
            CustomOrderCheckList(
                color = "black",
                optionState = "접수대기",
                optionName = "쏘큣(곰돌이) 케이크",
                optionOwner = "김성진",
                optionDate = "2022.08.22",
                optionTime = "13:34",
                onClick = { }
            )
        }

        if(isVisible.value) {
            CustomerOCDScreen(onCancel = {
                isVisible.value = false
                isVisible2.value = false
                Toast.makeText(mContext, "진윤정님의 주문이 수락되었습니다", Toast.LENGTH_LONG).show()
            }, isStore = true)
        }
    }
}

@Composable
fun DevideLine(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .background(color = Color(0xffB5B5B5)))
}