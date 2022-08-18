package com.problemsolver.myorder.app.presentation.StoreDetail

import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.problemsolver.myorder.R
import com.problemsolver.myorder.app.presentation.StoreList.StoreItemImage
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.problemsolver.myorder.app.domain.util.log
import com.problemsolver.myorder.app.presentation.postDemand.BottomSheetScreen
import com.problemsolver.myorder.app.presentation.util.BitmapConverter
import com.problemsolver.myorder.app.presentation.util.BitmapConverter.StringToImageBitmap
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StoreDetailScreen(
	viewModel: StoreDetailViewModel = hiltViewModel()
) {
	if (viewModel.state.value.isLoading) "LOADING!!".log()
	else {
		BottomSheetScreen(
			viewModel = viewModel
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
						StoreDetailOption(
							optionName = it.name,
							image = it.img,
							description = it.description,
							price = it.minPrice,
						) {
							viewModel.onEvent(StoreDetailEvent.clickCake(it.option))
							scope.launch {
								state.animateTo(
									ModalBottomSheetValue.Expanded,
									tween(500)
								)
							}
						}
					}
				}
			}
		}
	}
}


@Composable
fun StoreDetailMainPic(
	bitmap: ImageBitmap?,
	title: String = "",
	modifier: Modifier = Modifier
) {
	Image(
		bitmap = (if (bitmap != null) bitmap else R.drawable.sample_cake) as ImageBitmap,
		contentDescription = title,
		contentScale = ContentScale.Crop,
		modifier = modifier
			.fillMaxWidth()
			.padding(30.dp)
			.shadow(elevation = 5.dp, shape = RoundedCornerShape(5.dp))

	)
}

@Composable
fun StoreDetailDescription(
	title: String,
	content: String = ""
) {
	Column(
		modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(
			text = title, fontSize = 20.sp
		)
		Spacer(modifier = Modifier.size(5.dp))
		Box(
			modifier = Modifier.fillMaxWidth()
		) {
			timeSelector(modifier = Modifier.align(Alignment.Center), { /* TODO */ })
		}
		Spacer(modifier = Modifier.size(5.dp))
		Text(text = content)
	}
}

@Composable
fun timeSelector(
	modifier: Modifier = Modifier, onCheckedChange: () -> Unit
) {
	val categoryList = listOf(
		"월 11:00 ~ 17:00",
		"화 11:00 ~ 17:00",
		"수 11:00 ~ 17:00",
		"목 11:00 ~ 17:00",
		"금 11:00 ~ 17:00",
		"토 11:00 ~ 17:00",
		"일 11:00 ~ 17:00",
	)
	var isDropDownMenuExpanded by remember { mutableStateOf(false) }
	var selectedText by remember { mutableStateOf("영업시간 보기") }

	Row(modifier = modifier) {
		Text(
			text = selectedText,
			modifier = Modifier.align(Alignment.CenterVertically),
			fontSize = 15.sp
		)

		IconToggleButton(
			modifier = Modifier.size(30.dp),
			checked = isDropDownMenuExpanded,
			onCheckedChange = { onCheckedChange() },
		) {
			var isDropDownMenuExpanded by remember { mutableStateOf(false) }
			Icon(Icons.Default.KeyboardArrowDown,
				contentDescription = "arrow down",
				modifier = Modifier
					.size(30.dp)
					.clickable { isDropDownMenuExpanded = true })

			DropdownMenu(
				modifier = Modifier.wrapContentSize(),
				expanded = isDropDownMenuExpanded,
				onDismissRequest = { isDropDownMenuExpanded = false },
			) {
				repeat(7) {

					DropdownMenuItem(
						modifier = Modifier.width(200.dp), onClick = {
							selectedText = categoryList.get(it)
							isDropDownMenuExpanded = false
						}, contentPadding = PaddingValues(horizontal = 20.dp)
					) {
						Text(text = categoryList.get(it))
					}
				}
			}
		}
	}
}

@Composable
fun DivideLine() {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(2.dp)
			.background(color = Color.LightGray)
	) {

	}
}

@Composable
fun StoreDetailList() {


}

@Composable
fun StoreDetailOption(
	modifier: Modifier = Modifier.padding(10.dp),
	optionName: String,
	description: String,
	image: String,
	price: Int,
	onClick: () -> Unit = {}
) {
	Column(modifier = modifier.clickable(onClick = onClick)) {
		var bitmap = BitmapConverter.StringToImageBitmap(image)
		StoreItemImage(bitmap!!, optionName)
		Spacer(modifier = Modifier.size(5.dp))
		Text(text = optionName, fontSize = 16.sp)
		Spacer(modifier = Modifier.size(5.dp))
		Text(text = description, fontSize = 14.sp)
		Text(text = price.toString(), fontSize = 16.sp)
		Spacer(modifier = Modifier.size(20.dp))
	}
}

@Composable
fun StoreDetailOptionImage(
	imageUrl: String, modifier: Modifier = Modifier
) {
	AsyncImage(
		model = ImageRequest.Builder(LocalContext.current).data(imageUrl).crossfade(true).build(),
		contentDescription = "option image",
		placeholder = painterResource(R.drawable.sample_cake),
		contentScale = ContentScale.Crop,
		modifier = modifier
			.fillMaxWidth()
			.shadow(elevation = 5.dp, shape = RoundedCornerShape(5.dp))
	)
}

@Preview
@Composable
fun preDetail() {
//	StoreDetailScreen(rememberNavController())
}