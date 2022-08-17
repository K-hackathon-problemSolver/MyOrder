package com.problemsolver.myorder.app.presentation.StoreDetail

import com.problemsolver.myorder.app.data.remote.response.StoreDetailDTO

data class StoreDetailState(
	val isLoading: Boolean = true,
	val storeDetail: StoreDetailDTO = StoreDetailDTO(),
	val error: String = ""
)
