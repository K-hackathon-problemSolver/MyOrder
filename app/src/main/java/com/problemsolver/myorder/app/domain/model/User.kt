package com.problemsolver.myorder.app.domain.model

data class User(
	val uuid: String = "",
	val token: String = "",
	var type: String = "customer"
)
