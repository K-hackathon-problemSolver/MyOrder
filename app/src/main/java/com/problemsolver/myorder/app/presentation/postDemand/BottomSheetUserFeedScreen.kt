package com.problemsolver.myorder.app.presentation.postDemand

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.problemsolver.myorder.app.presentation.StoreDetail.PostDemandScreen
import com.problemsolver.myorder.app.presentation.StoreDetail.StoreDetailViewModel
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetScreen(
	viewModel: StoreDetailViewModel,
	navController: NavController,
	activityContentScope: @Composable (state: ModalBottomSheetState, scope: CoroutineScope) -> Unit,
){
	val state = rememberModalBottomSheetState(
		initialValue = ModalBottomSheetValue.Hidden,
		skipHalfExpanded = true
	)
	val scope = rememberCoroutineScope()

	ModalBottomSheetLayout(
		sheetElevation = 5.dp,
		sheetShape = RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp),
		sheetState = state,
		sheetContent = {
			PostDemandScreen(
				viewModel = viewModel,
				navController = navController
			)
		}
	) {
		activityContentScope(state, scope)
	}
}