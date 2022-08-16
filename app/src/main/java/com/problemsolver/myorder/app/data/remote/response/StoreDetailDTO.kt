package com.problemsolver.myorder.app.data.remote.response

data class StoreDetailDTO(
	val uuid: String? = null,
	val mainImg: String? = null,
	val extension: String? = null,
	val name: String? = null,
	val cakeList: List<CakeDTO>? = null
)
