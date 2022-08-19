package com.problemsolver.myorder.app.presentation.OrderCheck

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.problemsolver.myorder.app._enums.OrderType
import com.problemsolver.myorder.app.domain.use_cases.GetTypedOrderList
import com.problemsolver.myorder.app.domain.util.Resource
import com.problemsolver.myorder.app.domain.util.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class OrderCheckViewModel @Inject constructor(
	val getTypedOrderListUseCase: GetTypedOrderList
): ViewModel() {
	private var _state = mutableStateOf(OrderCheckState())
	val state: State<OrderCheckState> = _state

	private var _type = mutableStateOf<OrderType>(OrderType.WAITING)
	val type: State<OrderType> = _type

	init {
		getOrderList()
	}

	fun getOrderList(
		id: String = "08593046-29e1-4891-bc32-7731a4aeb432",
		size: Int = 10,
		page: Int = 0,
		sort: String? = null
	) {
		getTypedOrderListUseCase(type.value, id, size, page, sort).onEach { result ->
			when (result) {
				is Resource.Success -> {
					_state.value = OrderCheckState(isLoading = false, orderList = result.data ?: emptyList())
					"ordercheck success : ${result.data}".log()
				}
				is Resource.Error -> {
					_state.value = OrderCheckState(error = result.message ?: "An unexpected error occured")
					"ordercheck error".log()
				}
				is Resource.Loading -> {
					_state.value = OrderCheckState(isLoading = true)
					"ordercheck loading".log()
				}
			}
		}.launchIn(viewModelScope)
	}

	fun onTypeChanged(type: OrderType) {
		_type.value = type
		getOrderList()
	}
}