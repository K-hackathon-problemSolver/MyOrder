package com.problemsolver.myorder.app._enums

sealed class OrderType(val value: String) {
	object WAITING : OrderType("WAITING")
	object ACCEPTED : OrderType("ACCEPTED")
	object COMPLETED : OrderType("COMPLETED")
	object REJECTED : OrderType("REJECTED")
}