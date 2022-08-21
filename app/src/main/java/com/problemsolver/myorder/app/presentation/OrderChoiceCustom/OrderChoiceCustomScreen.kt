package com.problemsolver.myorder.app.presentation.OrderChoiceCustom

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.problemsolver.myorder.R
import com.problemsolver.myorder.app.domain.model.Category
import com.problemsolver.myorder.app.domain.model.Option

@Composable
fun OrderChoiceCustomScreen(
	viewModel: OrderChoiceCustomViewModel = hiltViewModel()
) {

	Scaffold(
		floatingActionButton = {
			Button(
				modifier = Modifier.fillMaxWidth(0.9f),
				onClick = { viewModel.addCategory(Category("", emptyList()))},
				colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff78C3FA)
				)
			) {
				Text(
					text = "카테고리 추가하기",
					color = Color.White
				)
			}
		}
	) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = Color.White)
		) {

			CustomTopBar()

			LazyColumn(
				modifier = Modifier.background(Color.White)
			) {
				viewModel.categories.forEachIndexed { categoryIdx, category ->
					item {
						Column(
							Modifier.fillMaxWidth(),
							horizontalAlignment = Alignment.CenterHorizontally
						) {
							Row(
								verticalAlignment = Alignment.CenterVertically,
								horizontalArrangement = Arrangement.SpaceAround
							){
								Text("카테고리 명")
								Spacer(modifier = Modifier.width(10.dp))
								TextField(modifier = Modifier.height(30.dp),
									colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
									value = category.categoryName,
									shape = RoundedCornerShape(8.dp),
									onValueChange = {
										viewModel.onCategoryNameChanged(
											it,
											categoryIdx
										)
									}
								)
							}
							Spacer(modifier = Modifier.height(10.dp))
							category.options.forEachIndexed { optionIndex, option ->
								Row(
									modifier = Modifier
										.fillMaxWidth()
										.padding(bottom = 10.dp)
										.padding(horizontal = 10.dp),
									verticalAlignment = Alignment.CenterVertically
								){
									Row(
										modifier = Modifier.weight(2f),
										verticalAlignment = Alignment.CenterVertically
									) {
										Text(
											text = "옵션 명",
											modifier = Modifier.width(50.dp)
										)
										OutlinedTextField(
											value = option.detail,
											onValueChange = {
												viewModel.onOptionChanged(
													it,
													categoryIdx,
													optionIndex
												)
											},
											modifier = Modifier
												.fillMaxWidth()
												.height(20.dp)
										)
									}
									Spacer(modifier = Modifier.width(10.dp))
									Row(
										modifier = Modifier.weight(2f),
										verticalAlignment = Alignment.CenterVertically
									) {
										Text(
											text = "가격",
											modifier = Modifier.width(50.dp)
										)
										var text = remember { mutableStateOf("") }
										OutlinedTextField(
											value = if(option.price != null) option.price.toString() else "" ,
											onValueChange = {
												viewModel.onPriceChanged(
													if (it.isBlank()) null else it.toInt(),
													categoryIdx,
													optionIndex
												)
											},
											keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
											modifier = Modifier
												.width(100.dp)
												.height(10.dp)
										)
									}
									Image(
										painterResource(id = R.drawable.minus),
										contentDescription = "option delete",
										modifier = Modifier
											.size(30.dp)
											.clickable {
												viewModel.removeOption(categoryIdx, optionIndex)
											}
									)
								}
							}
							Spacer(modifier = Modifier.height(10.dp))

							Row(Modifier.fillMaxWidth(0.9f)) {
								Button(
									modifier = Modifier.weight(1f),
									onClick = { viewModel.addOption(categoryIdx) },
									colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF78C3FA)
									)
								) {
									Text(
										text = "옵션 추가",
										color = Color.White
									)
								}
								Spacer(modifier = Modifier.weight(0.2f))
								Button(
									modifier = Modifier.weight(1f),
									onClick = { viewModel.removeCategory(categoryIdx) },
									colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF78C3FA)
									)
								) {
									Text(
										text = "카테고리 제거",
										color = Color.White
									)
								}
							}
							Spacer(modifier = Modifier.height(10.dp))



						}

					}
				}
			}
		}
	}
}



@Composable
fun ColumnScope.CustomTopBar(
	upPress: () -> Unit = {},
	onApplyClicked: () -> Unit = {}
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(10.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		TextButton(
			modifier = Modifier.weight(2f),
			onClick = upPress,
		) {
			Text(
				text = "취소",
				color = Color.Black
			)
		}
		Text(
			modifier = Modifier.weight(8f),
			textAlign = TextAlign.Center,
			text = "주문서 수정",
			fontWeight = FontWeight.Bold,
			fontSize = 15.sp
		)
		TextButton(modifier = Modifier.weight(2f),
			onClick = onApplyClicked) {
			Text(
				text = "적용",
				color = Color.Black
			)
		}
	}
	Spacer(modifier = Modifier.height(50.dp))
}

@Preview
@Composable
fun prqwe() {
	OrderChoiceCustomScreen()
}