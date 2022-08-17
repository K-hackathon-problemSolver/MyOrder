package com.problemsolver.myorder.app.presentation.StoreDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.datatransport.runtime.Destination
import com.problemsolver.myorder.app.domain.use_cases.GetStoreDetail
import com.problemsolver.myorder.app.domain.util.Resource
import com.problemsolver.myorder.app.domain.util.log
import com.problemsolver.myorder.app.presentation.navigation.DetailDestinationKey
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StoreDetailViewModel @Inject constructor(
	private val getStoreDetailUseCase: GetStoreDetail,
	savedStateHandle: SavedStateHandle,
) : ViewModel() {

	private val storeId: String? = savedStateHandle[DetailDestinationKey.STORE]

	private val _state = mutableStateOf(StoreDetailState())
	val state: State<StoreDetailState> = _state

	init {
		if (!storeId.isNullOrBlank()) getStoreDetail(storeId!!)
	}

	private fun getStoreDetail(id: String) {
		getStoreDetailUseCase(id).onEach { result ->
			when (result) {
				is Resource.Success -> {
					_state.value = StoreDetailState(isLoading = false, storeDetail = result.data!!)
					"getStoreDetail success : ${result.data}".log()
				}
				is Resource.Error -> {
					_state.value =
						StoreDetailState(error = result.message ?: "An unexpected error occured")
					"getStoreDetail error".log()
				}
				is Resource.Loading -> {
					_state.value = StoreDetailState(isLoading = true)
					"getStoreDetail loading".log()
				}
			}
		}.launchIn(viewModelScope)
	}
}