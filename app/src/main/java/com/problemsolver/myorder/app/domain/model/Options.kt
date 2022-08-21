package com.problemsolver.myorder.app.domain.model

import com.google.gson.annotations.SerializedName

data class Options(
	val data: MutableMap<String, MutableMap<String, Int>?> = mutableMapOf()
)
