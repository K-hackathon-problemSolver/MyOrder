package com.problemsolver.myorder.app.presentation.CustomerOrderCheck

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.problemsolver.myorder.app.presentation.CustomerOrderCheckDetail.CustomerOCDScreen


@Composable
fun CustomerOrderCheckScreen(
	viewModel: CustomerOrderCheckViewModel = hiltViewModel()
) {
	val scrollState = rememberScrollState()

	Box(modifier = Modifier.fillMaxSize()){

		Column(
			modifier = Modifier.fillMaxSize()
				.background(color = Color.White)
				.padding(20.dp)
				.verticalScroll(scrollState)
		) {
			Spacer(modifier = Modifier.height(20.dp))
			CustomOrderCheckList(
				color = "green",
				optionState = "수락",
				optionName = "도시락 케이크",
				optionOwner = "프롬마틸다",
				optionDate = "2022.08.20",
				optionTime = "13:22",
				onClick = { viewModel.onDemandClick() }
			)
			/*CustomOrderCheckList(
				color = "green",
				optionState = "수락",
				optionName = "시그니처 케이크",
				optionOwner = "벌스데이걸 사직",
				optionDate = "2022.08.20",
				optionTime = "11:56",
				onClick = { viewModel.onDemandClick() }
			)
			 */
			CustomOrderCheckList(
				color = "red",
				optionState = "거절",
				optionName = "시그니처 케이크",
				optionOwner = "벌스데이걸 사직",
				optionDate = "2022.08.20",
				optionTime = "11:29",
				onClick = { viewModel.onDemandClick() }
			)
			CustomOrderCheckList(
				color = "black",
				optionState = "완료",
				optionName = "3단 트리플 케이크",
				optionOwner = "교대 녹는당케이크",
				optionDate = "2022.06.03",
				optionTime = "19:34",
				onClick = { viewModel.onDemandClick() }
			)
		}
	}
	if(viewModel.isVisible.value)
		CustomerOCDScreen(onCancel = {viewModel.onCancel()})
}




@Composable
fun ColumnScope.CustomOrderCheckList(
	color : String = "black",
    optionState: String = "",
    optionName: String,
    optionOwner: String,
    optionDate: String,
    optionTime: String,
	onClick: () -> Unit = {}
) {
	var devideColor = Color.Black
	var alp = 1f

	if (optionState == "완료") alp = 0.4f

    Box(
        modifier = Modifier
			.shadow(shape = RoundedCornerShape(8.dp), elevation = 4.dp)
			.fillMaxWidth()
			.background(Color.White)
			.padding(vertical = 10.dp)
			.clickable(onClick = onClick)
			.alpha(alp)
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


			if (color == "yellow")  devideColor = Color(0xff78C3FA)
			if (color == "green")  devideColor = Color.Green
			if (color == "red")  devideColor = Color.Red
			if (color == "black")  devideColor = Color.Black

			Box(
				modifier = Modifier
					.fillMaxWidth()
					.height(1.dp)
					.background(color = devideColor)
			)

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


@Preview
@Composable
fun pranything() {
	CustomerOrderCheckScreen()
}



