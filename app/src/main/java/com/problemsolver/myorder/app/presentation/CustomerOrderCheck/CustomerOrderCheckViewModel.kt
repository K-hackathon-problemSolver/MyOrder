package com.problemsolver.myorder.app.presentation.CustomerOrderCheck

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
import com.problemsolver.myorder.app.presentation.StoreList.StoreListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CustomerOrderCheckViewModel @Inject constructor(
) : ViewModel() {


}