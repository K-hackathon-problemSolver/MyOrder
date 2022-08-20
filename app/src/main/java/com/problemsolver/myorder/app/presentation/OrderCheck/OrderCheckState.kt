package com.problemsolver.myorder.app.presentation.OrderCheck

import com.problemsolver.myorder.app.data.remote.response.TypedOrderListDTO

data class OrderCheckState(
	val isLoading: Boolean = true,

	val error: String = ""
)
