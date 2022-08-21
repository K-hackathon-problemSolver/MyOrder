package com.problemsolver.myorder.app.presentation.CustomerOrderCheck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomerOrderCheckScreen() {

	val scrollState = rememberScrollState()

	Column(
		modifier = Modifier
            .background(color = Color.White)
            .padding(20.dp)
            .verticalScroll(scrollState)
	) {
		Spacer(modifier = Modifier.height(20.dp))
		CustomOrderCheckList(
			optionState = "접수 대기",
			optionName = "도시락 케이크",
			optionOwner = "프롬마틸다",
			optionDate = "2022.08.22",
			optionTime = "13:22"
		)
		CustomOrderCheckList(
			optionState = "수락",
			optionName = "시그니처 케이크",
			optionOwner = "벌스데이걸 사직",
			optionDate = "2022.08.20",
			optionTime = "11:56"
		)
		CustomOrderCheckList(
			optionState = "거절",
			optionName = "시그니처 케이크",
			optionOwner = "벌스데이걸 사직",
			optionDate = "2022.08.20",
			optionTime = "11:29"
		)
		CustomOrderCheckList(
			optionState = "완료",
			optionName = "3단 트리플 케이크",
			optionOwner = "교대 녹는당케이크",
			optionDate = "2022.06.03",
			optionTime = "19:34"
		)
	}
}

@Composable
fun ColumnScope.CustomOrderCheckList(
    optionState: String,
    optionName: String,
    optionOwner: String,
    optionDate: String,
    optionTime: String
) {
    Box(
        modifier = Modifier
	        .shadow(shape = RoundedCornerShape(8.dp), elevation = 4.dp)
            .fillMaxWidth()
	        .background(Color.White)
            .padding(vertical = 10.dp)
    ) {
        Column() {
            Text(
                text = optionState,
	            fontSize = 13.sp ,
	            fontWeight = FontWeight.Bold,
//                color = Color(0xFFFFC107),
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))

            DevideLine()

            Spacer(modifier = Modifier.height(10.dp))
            Text(
	            text = optionName,
	            fontSize = 19.sp,
	            fontWeight = FontWeight.Bold,
	            modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row(modifier = Modifier.padding(horizontal = 10.dp)) {
                Text(
	                text = optionOwner,
	                fontSize = 13.sp ,
	                fontWeight = FontWeight.Bold,
	                color = com.problemsolver.myorder.ui.theme.LightGray
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
	                text = optionDate,
	                fontSize = 13.sp ,
	                color = com.problemsolver.myorder.ui.theme.LightGray
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
	                text = optionTime,
	                fontSize = 13.sp ,
	                color = com.problemsolver.myorder.ui.theme.LightGray
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun DevideLine() {
	Box(
		modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color(0xffB5B5B5))
	)
}

@Preview
@Composable
fun pranything() {
	CustomerOrderCheckScreen()
}



