package com.problemsolver.myorder.app.presentation.OrderCheck

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.problemsolver.myorder.app._enums.OrderType
import com.problemsolver.myorder.app.data.remote.response.TypedOrderListDTO
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

	private var _waiting = mutableStateListOf<TypedOrderListDTO>()
	private var _accepted = mutableStateListOf<TypedOrderListDTO>()
	private var _completed = mutableStateListOf<TypedOrderListDTO>()
	private var _rejected = mutableStateListOf<TypedOrderListDTO>()

	val waiting: SnapshotStateList<TypedOrderListDTO> = _waiting
	val accepted: SnapshotStateList<TypedOrderListDTO> = _accepted
	val completed: SnapshotStateList<TypedOrderListDTO> = _completed
	val rejected: SnapshotStateList<TypedOrderListDTO> = _rejected


	init {
		getOrderList(OrderType.WAITING)
		getOrderList(OrderType.ACCEPTED)
		getOrderList(OrderType.COMPLETED)
		getOrderList(OrderType.REJECTED)
	}

	fun getOrderList(
		type: OrderType = _type.value,
		id: String = "08593046-29e1-4891-bc32-7731a4aeb432",
		size: Int = 10,
		page: Int = 0,
		sort: String? = null
	) {
		getTypedOrderListUseCase(type, id, size, page, sort).onEach { result ->
			when (result) {
				is Resource.Success -> {
					when(type) {
						is OrderType.WAITING -> { _waiting = (result.data ?: emptyList()) as SnapshotStateList<TypedOrderListDTO> }
						is OrderType.ACCEPTED -> { _accepted = (result.data ?: emptyList()) as SnapshotStateList<TypedOrderListDTO> }
						is OrderType.COMPLETED -> { _completed = (result.data ?: emptyList()) as SnapshotStateList<TypedOrderListDTO> }
						is OrderType.REJECTED -> { _rejected = (result.data ?: emptyList()) as SnapshotStateList<TypedOrderListDTO> }
					}
					"ordercheck success : ${result.data}".log()
				}
				is Resource.Error -> "order check error".log()
				is Resource.Loading -> "order check loading".log()
			}
		}.launchIn(viewModelScope)
	}

	fun onTypeChanged(type: OrderType) {
		_type.value = type
		getOrderList()
	}
}