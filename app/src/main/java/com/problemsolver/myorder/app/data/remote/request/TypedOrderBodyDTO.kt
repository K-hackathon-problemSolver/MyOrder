package com.problemsolver.myorder.app.data.remote.request

import java.util.*


data class TypedOrderBodyDTO(
	val uuid: String? = null,
	val size: Int? = null,
	val page: Int? = null,
	val sort: String? = null
)