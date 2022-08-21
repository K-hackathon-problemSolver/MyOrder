package com.problemsolver.myorder.app.presentation.StoreDetail

import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.problemsolver.myorder.app.domain.model.Category
import com.problemsolver.myorder.app.domain.util.log
import com.problemsolver.myorder.app.presentation.navigation.Screen
import com.problemsolver.myorder.app.presentation.postDemand.BottomSheetScreen
import com.problemsolver.myorder.app.presentation.util.BitmapConverter.StringToImageBitmap
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BossStoreDetailScreen(
	navController: NavController,
	viewModel: StoreDetailViewModel = hiltViewModel()
) {
	if (viewModel.state.value.isLoading) "LOADING!!".log()
	else {
		BottomSheetScreen(
			viewModel = viewModel,
			navController = navController
		) { state, scope ->


			LazyVerticalGrid(
				columns = GridCells.Fixed(count = 2),
				contentPadding = PaddingValues(20.dp),
				modifier = Modifier.background(Color.White)
			) {
				val storeDetail = viewModel.state.value.storeDetail
				storeDetail.toString().log()

				item(span = { GridItemSpan(2) }) {
					Column() {
						val bitmap = StringToImageBitmap(storeDetail.mainImg!!)
						StoreDetailMainPic(bitmap = bitmap)
						StoreDetailDescription(
							title = storeDetail.name!!,
							content = storeDetail.description!!
						)
						Spacer(modifier = Modifier.height(10.dp))
						DivideLine()
						StoreDetailList()

					}
				}

				viewModel.state.value.storeDetail.cakeList?.forEach {
					item {
						Column() {

							StoreDetailOption(
								optionName = it.name,
								image = it.img,
								description = it.description,
								price = it.minPrice,
							) {
								viewModel.onEvent(StoreDetailEvent.clickCake(it.uuid, it.option))
								scope.launch {
									state.animateTo(
										ModalBottomSheetValue.Expanded,
										tween(500)
									)
								}
							}

							Button(
								modifier = Modifier.fillMaxWidth(0.9f),
								onClick = { navController.navigate(Screen.OrderChoiceCustomScreen.route) },
								colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff78C3FA)
								)
							) {
								Text(
									text = "카테고리 수정",
									color = Color.White,
									fontWeight = FontWeight.Bold
								)
							}
						}
					}
				}
			}
		}
	}
}



//@Preview
//@Composable
//fun preDetail() {
////	StoreDetailScreen(rememberNavController())
//}