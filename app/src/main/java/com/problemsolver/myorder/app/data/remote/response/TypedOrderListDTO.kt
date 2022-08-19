package com.problemsolver.myorder.app.data.remote.response


data class TypedOrderListDTO(
	var uuid: String? = null,
	var cakeName: String? = null,
	var option: String? = null,
	var price: Int? = null
)