package com.problemsolver.myorder.app.presentation.StoreList

import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.problemsolver.myorder.app.domain.use_cases.GetStoreList
import com.problemsolver.myorder.app.domain.util.Resource
import com.problemsolver.myorder.app.domain.util.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StoreListViewModel @Inject constructor(
	private val getStoreListUseCase: GetStoreList
): ViewModel() {

	private val _state = mutableStateOf(StoreListState())
	val state: State<StoreListState> = _state

	private var location = mutableStateOf("SUYUNG")

	init {
		getStoreList(location.value, 0, 20)
	}

	private fun getStoreList(location: String, offset: Int, limit: Int) {
		getStoreListUseCase(location, offset, limit).onEach { result ->
			when (result) {
				is Resource.Success -> {
                    _state.value = StoreListState(isLoading = false, storeList = result.data ?: emptyList())
					"getStoreList success : ${result.data}".log()
				}
				is Resource.Error -> {
                    _state.value = StoreListState(error = result.message ?: "An unexpected error occured")
					"getStoreList error".log()
				}
				is Resource.Loading -> {
                    _state.value = StoreListState(isLoading = true)
					"getStoreList loading".log()
				}
			}

		}.launchIn(viewModelScope)
	}

	fun changeLocation(location: String) {
		this.location.value = location
		"change location : $location".log()
		getStoreList(location, 0, 20)
	}
}