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
import com.problemsolver.myorder.app.presentation.postDemand.Date
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

	private var _state = mutableStateOf(StoreDetailState())
	val state: State<StoreDetailState> = _state

<<<<<<< Updated upstream
=======
	private var _option = mutableStateOf("")
	val option: State<String> = _option

	private var _date = mutableStateOf(Date())
	val date: State<Date> = _date

>>>>>>> Stashed changes
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
	fun onEvent(event: StoreDetailEvent) {
		when(event) {
			is StoreDetailEvent.clickCake -> {
				_option.value = event.value
			}
		}
	}

	fun onDateChanged(year: Int, month: Int, day: Int) {
		_date.value.year = year
		_date.value.month = month
		_date.value.day = day
	}
}