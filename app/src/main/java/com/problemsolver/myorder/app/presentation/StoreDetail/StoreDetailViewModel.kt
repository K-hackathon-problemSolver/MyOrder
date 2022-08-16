package com.problemsolver.myorder.app.presentation.StoreDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.problemsolver.myorder.app.domain.use_cases.GetStoreDetail
import com.problemsolver.myorder.app.domain.use_cases.GetStoreList
import com.problemsolver.myorder.app.domain.util.Resource
import com.problemsolver.myorder.app.domain.util.log
import com.problemsolver.myorder.app.presentation.StoreList.StoreListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class StoreDetailViewModel @Inject constructor(
	private val getStoreDetailUseCase: GetStoreDetail
): ViewModel() {

	private val _state = mutableStateOf(StoreDetailState())
	val state: State<StoreDetailState> = _state

	private fun getStoreDetail(id: String) {
		getStoreDetailUseCase(id).onEach { result ->
			when (result) {
				is Resource.Success -> {
					_state.value = StoreDetailState(storeDetail = result.data!!)
					"getStoreList success : ${result.data}".log()
				}
				is Resource.Error -> {
					_state.value = StoreDetailState(error = result.message ?: "An unexpected error occured")
					"getStoreList error".log()
				}
				is Resource.Loading -> {
					_state.value = StoreDetailState(isLoading = true)
					"getStoreList loading".log()
				}
			}

		}.launchIn(viewModelScope)
	}
}