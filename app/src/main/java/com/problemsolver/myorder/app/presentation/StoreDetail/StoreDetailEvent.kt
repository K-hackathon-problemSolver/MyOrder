package com.problemsolver.myorder.app.presentation.StoreDetail

import android.net.Uri

sealed class StoreDetailEvent {
	data class clickCake(val cakeId: String, val option: String): StoreDetailEvent()
	data class dateChanged(val year: Int, val month: Int, val day: Int): StoreDetailEvent()
	data class priceChanged(val price: Int): StoreDetailEvent()
	data class imageSelected(val uri: Uri): StoreDetailEvent()
	data class imageRemoved(val uri: Uri?): StoreDetailEvent()
	object SaveDemand: StoreDetailEvent()
}