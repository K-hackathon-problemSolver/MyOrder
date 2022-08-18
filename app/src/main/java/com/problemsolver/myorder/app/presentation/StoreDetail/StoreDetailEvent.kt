package com.problemsolver.myorder.app.presentation.StoreDetail

sealed class StoreDetailEvent {
	data class clickCake(val value: String): StoreDetailEvent()

	object SaveDemand: StoreDetailEvent()
}