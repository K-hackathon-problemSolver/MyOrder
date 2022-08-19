package com.problemsolver.myorder.app.presentation.StoreDetail

sealed class StoreDetailEvent {
	data class clickCake(val cakeId: String, val option: String): StoreDetailEvent()
	data class dateChanged(val year: Int, val month: Int, val day: Int): StoreDetailEvent()
	data class priceChanged(val price: Int): StoreDetailEvent()
	object SaveDemand: StoreDetailEvent()
}