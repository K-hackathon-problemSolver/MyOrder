package com.problemsolver.myorder.app.presentation.StoreList

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.problemsolver.myorder.app.domain.use_cases.GetStoreList
import com.problemsolver.myorder.app.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StoreListViewModel @Inject constructor(
	private val getStoreListUseCase: GetStoreList
): ViewModel() {

	private val _state = mutableStateOf(StoreListState())
	val state: State<StoreListState> = _state

	private var location: String = "SUYUNG"

	init {
		getStoreList(location, 0, 20)
	}

	private fun getStoreList(location: String, offset: Int, limit: Int) {
		getStoreListUseCase(location, offset, limit).onEach { result ->
			when (result) {
				is Resource.Success -> {
                    _state.value = StoreListState(storeList = result.data ?: emptyList())
					Log.d("test", "success : ${result.data.toString()}")
				}
				is Resource.Error -> {
                    _state.value = StoreListState(error = result.message ?: "An unexpected error occured")
					Log.d("test", "error")
				}
				is Resource.Loading -> {
                    _state.value = StoreListState(isLoading = true)
					Log.d("test", "loading")
				}
			}

		}.launchIn(viewModelScope)
	}

	fun changeLocation(location: String) {
		this.location = location
		getStoreList(location, 0, 20)
	}
}