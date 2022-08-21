package com.problemsolver.myorder.app.domain.model

data class Category(
	var categoryName: String = "",
	val options: List<Option> = emptyList()
) {
	fun getOptionList(): MutableList<Option> {
		return options.toMutableList()
	}
}
