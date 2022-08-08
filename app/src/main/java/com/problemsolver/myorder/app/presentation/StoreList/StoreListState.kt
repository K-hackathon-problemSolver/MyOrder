package com.problemsolver.myorder.app.presentation.StoreList

import com.problemsolver.myorder.app.data.remote.dto.StoreDTO


data class StoreListState(
	val isLoading: Boolean = false,
	val storeList: List<StoreDTO> = emptyList(),
	val error: String = ""
)