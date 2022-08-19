package com.problemsolver.myorder.app.presentation.StoreDetail

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.problemsolver.myorder.R
import com.problemsolver.myorder.app.domain.model.Options
import com.problemsolver.myorder.app.domain.util.log
import java.util.*

@Composable
fun PostDemandScreen(
	viewModel: StoreDetailViewModel
) {
	// 서버의 test db가 아직 <Options> 를 serialized 한 내용이 아니므로 하드코딩함
	val test = Options()
	test.data.put("시트선택", mutableMapOf("기본맛(커스터드)" to 6900, "크림치즈" to 7900, "버터크림" to 6900))
	test.data.put("사이즈", mutableMapOf("1호" to 1200, "2호" to 1400, "3호" to 1500))
	test.data.put("모양선택", mutableMapOf("원형" to 1200, "네모" to 1400, "하트" to 1500, "별" to 1600))
	test.data.put("보냉여부", mutableMapOf("유" to 500, "무" to 0))
	test.data.put("문구", null)
	val testOption = Gson().toJson(test)

	"ViewModel.option.value".log()
	viewModel.option.value.log()

	Scaffold(
		floatingActionButton = {
			FloatingOrderBar()
		},
		floatingActionButtonPosition = FabPosition.Center,
		modifier = Modifier
			.padding(top = 30.dp)
			.fillMaxWidth()
			.heightIn(min = 300.dp, max = 500.dp)
			.background(color = Color.White)
	) {
		Column(
			modifier = Modifier.fillMaxSize()
		) {
			OrderChoiceHeader(onDateChanged = { y, m, d -> viewModel.onDateChanged(y, m, d) })
			OrderChoiceOptions(testOption)
		}
	}
}

@Composable
fun ColumnScope.OrderChoiceHeader(
	onDateChanged: (Int, Int, Int) -> Unit
) {
	val mYear: Int
	val mMonth: Int
	val mDay: Int
	val mCalendar = Calendar.getInstance()
	mYear = mCalendar.get(Calendar.YEAR)
	mMonth = mCalendar.get(Calendar.MONTH)
	mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

	mCalendar.time = Date()

	val mDate = remember { mutableStateOf("") }

	val mDatePickerDialog = DatePickerDialog(
		LocalContext.current,
		{ _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
			onDateChanged(mYear, mMonth, mDayOfMonth)
			mDate.value = "$mYear 년 $mMonth 월 $mDay 일 ▼"
		}, mYear, mMonth, mDay
	)

	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(20.dp),
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		Text("주문 가능 날짜")
		Text(
			text = mDate.value.ifBlank { "날짜 선택 ▼" },
			modifier = Modifier.clickable{ mDatePickerDialog.show() }
		)
	}
}

@Composable
fun ColumnScope.OrderChoiceOptions(
	optionsStr: String
) {
	val scrollstate = rememberScrollState()

	optionsStr.log()
	val options = Gson().fromJson(optionsStr, Options::class.java)
	options.toString().log()

	Column(
		modifier = Modifier
			.fillMaxSize()
			.verticalScroll(scrollstate)
			.padding(horizontal = 20.dp)
			.padding(bottom = 80.dp)
	) {
		options.data.forEach { (category, map) ->
			OrderChoiceDetail(
				optionName = category, options = map?.toList()
			)
		}
		DivideLine()

		Column(modifier = Modifier.fillMaxWidth()) {

			val textState = remember {
				mutableStateOf("")
			}

			Text(text = "요청사항")
			Spacer(modifier = Modifier.height(10.dp))
			TextField(value = textState.value,
				onValueChange = { textValue -> textState.value = textValue })
			Spacer(modifier = Modifier.height(20.dp))
		}
		DivideLine()

		Column(modifier = Modifier.fillMaxWidth()) {
			Text(text = "이미지첨부")
			Box(modifier = Modifier.fillMaxWidth()) {
				Row(
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween
				) {
					Button(
						modifier = Modifier.weight(1f),
						onClick = { /* Do something! */ },
						colors = ButtonDefaults.textButtonColors(
							backgroundColor = Color.White,
						)
					) {
						Icon(
							painter = painterResource(id = R.drawable.camera),
							contentDescription = "take picture",
							tint = Color.LightGray
						)
					}
					Button(
						modifier = Modifier.weight(1f),
						onClick = { /* Do something! */ },
						colors = ButtonDefaults.textButtonColors(
							backgroundColor = Color.White
						)
					) {
						Icon(
							painter = painterResource(id = R.drawable.file_upload),
							contentDescription = "file upload",
							tint = Color.LightGray
						)
					}
				}
			}
		}
	}
}

@Composable
fun OrderChoiceDetail(
	optionName: String, options: List<Pair<String, Int>>?
) {

	Column(
		modifier = Modifier.fillMaxWidth()
	) {
		Row(
			modifier = Modifier.fillMaxWidth()
		) {
			Text(text = optionName)
		}
		options?.onEach {
			OrderChoiceDetailBody(
				optionDetail = it.first,
				optionPrice = it.second
			)
		}
	}
}

@Composable
fun OrderChoiceDetailBody(
	optionDetail: String, optionPrice: Int
) {

	val checkedState = remember { mutableStateOf(false) }

	Row(
		modifier = Modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically
	) {
		Row(verticalAlignment = Alignment.CenterVertically) {
			Checkbox(checked = checkedState.value, onCheckedChange = { checkedState.value = it })
			Text(text = optionDetail, fontWeight = FontWeight.Bold)
		}
		Text(text = "$optionPrice 원", fontWeight = FontWeight.Bold)
	}

}

@Composable
fun FloatingOrderBar(
	finalPrice: Int = 777
) {
	Button(
		modifier = Modifier.fillMaxWidth(0.9f),
		onClick = { /*TODO*/ },
		colors = ButtonDefaults.buttonColors(
			backgroundColor = Color(0xff78C3FA)
		)
	) {
		Text(
			text = "${finalPrice}원 주문하기", color = Color.White
		)
	}
}


@Composable
fun ColumnScope.DivideLine() {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(1.dp)
			.background(Color(0xff78BBFA))
	)
	Spacer(modifier = Modifier.height(10.dp))
}

@Preview
@Composable
fun previewsomething() {
//	PostDemandScreen()
}