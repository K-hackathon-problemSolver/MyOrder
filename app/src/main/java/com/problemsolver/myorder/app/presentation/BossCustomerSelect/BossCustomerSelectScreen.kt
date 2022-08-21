package com.problemsolver.myorder.app.presentation.BossCustomerSelect

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.problemsolver.myorder.R
import com.problemsolver.myorder.app.presentation.navigation.Screen

@Composable
fun BossCustomerSelectScreen(
	navController: NavController,
	viewModel: SelectorViewModel = hiltViewModel()
) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(color = Color.White)
	) {
		SelectHeader()

		Spacer(modifier = Modifier.height(100.dp))
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 20.dp)
				.weight(7f),
			horizontalArrangement = Arrangement.SpaceAround
		) {
			Column(
				modifier = Modifier,
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Text(text = "특별한 주문을")
				Text(text = "드리고 싶어요!")
				Spacer(modifier = Modifier.height(10.dp))
				OutlinedButton(
					onClick = {
						viewModel.onSelected(false)
						navController.navigate(Screen.HomeScreen.route)
					},
					modifier = Modifier.size(130.dp),  //avoid the oval shape
					shape = CircleShape,
					border = BorderStroke(1.dp, Color(0xff78C3FA)),
					contentPadding = PaddingValues(0.dp),
					colors = ButtonDefaults.outlinedButtonColors(
						contentColor = Color.White,
						backgroundColor = Color(0xff78C3FA)
					)
				) {
					Column(
						modifier = Modifier.fillMaxWidth(),
						verticalArrangement = Arrangement.Center,
						horizontalAlignment = Alignment.CenterHorizontally
					) {
						Image(
							painter = painterResource(id = R.drawable.bossicon),
							contentDescription = "BossIcon",
							Modifier.size(50.dp)
						)
						Spacer(modifier = Modifier.height(10.dp))
						Text(text = "사장님")
					}
				}
			}
			Column(
				modifier = Modifier,
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Text(text = "특별한 주문을")
				Text(text = "하고 싶어요!")
				Spacer(modifier = Modifier.height(10.dp))
				OutlinedButton(
					onClick = {
						viewModel.onSelected(true)
						navController.navigate(Screen.HomeScreen.route)
					},
					modifier = Modifier.size(130.dp),  //avoid the oval shape
					shape = CircleShape,
					border = BorderStroke(1.dp, Color(0xff78C3FA)),
					contentPadding = PaddingValues(0.dp),
					colors = ButtonDefaults.outlinedButtonColors(
						contentColor = Color.White,
						backgroundColor = Color(0xff78C3FA)
					)
				) {
					Column(
						modifier = Modifier.fillMaxWidth(),
						verticalArrangement = Arrangement.Center,
						horizontalAlignment = Alignment.CenterHorizontally
					) {
						Image(
							painter = painterResource(id = R.drawable.customericon),
							contentDescription = "CustomerIcon",
							Modifier.size(50.dp)
						)
						Spacer(modifier = Modifier.height(10.dp))
						Text(text = "손님")
					}
				}
			}
		}
	}
}

@Composable
fun ColumnScope.SelectHeader() {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 50.dp, vertical = 50.dp)
			.weight(3f)
	) {
		Text(
			text = "어떤 일로 My Order를",
			fontSize = 25.sp
		)
		Text(
			text = "찾아주셨나요?",
			fontSize = 25.sp
		)
	}
}



@Preview
@Composable
fun prjkjk() {
	BossCustomerSelectScreen(rememberNavController())
}