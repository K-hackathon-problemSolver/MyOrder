package com.problemsolver.myorder.app.data.remote.response

data class StoreDetailDTO(
	val uuid: String?,
	val mainImg: String?,
	val extension: String?,
	val name: String?,
	val cakeList: List<CakeDTO>
)
