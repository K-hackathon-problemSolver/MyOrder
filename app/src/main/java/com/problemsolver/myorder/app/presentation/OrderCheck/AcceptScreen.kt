package com.problemsolver.myorder.app.presentation.OrderCheck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.problemsolver.myorder.app.presentation.CustomerOrderCheck.CustomOrderCheckList
import com.problemsolver.myorder.app.presentation.CustomerOrderCheckDetail.CustomerOCDScreen

@Composable
fun AcceptScreen() {

	val scrollState = rememberScrollState()
	val isVisible = remember { mutableStateOf(false) }

	Box(modifier = Modifier.fillMaxSize()) {

		Column(
			modifier = Modifier
				.background(color = Color.White)
				.padding(20.dp)
				.verticalScroll(scrollState)
		) {
			Spacer(modifier = Modifier.height(20.dp))
			CustomOrderCheckList(
				color = "green",
				optionState = "접수완료",
				optionName = "3단 트리플 케이크",
				optionOwner = "진윤정",
				optionDate = "2022.08.21",
				optionTime = "19:34",
				onClick = { isVisible.value = true }
			)
		}
		if(isVisible.value)
			CustomerOCDScreen(onCancel = { isVisible.value = false })
	}
}
