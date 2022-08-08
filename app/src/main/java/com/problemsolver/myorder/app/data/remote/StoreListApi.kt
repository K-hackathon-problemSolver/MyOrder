package com.problemsolver.myorder.app.data.remote

import com.problemsolver.myorder.app.data.remote.dto.StoreDTO
import com.problemsolver.myorder.app.data.remote.dto.StoreListBodyDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface StoreListApi {

	@Headers("Content-Type: application/json")
	@POST("/store/list")
	suspend fun getStoreList(@Body storeListBody: StoreListBodyDTO): Response<List<StoreDTO>>

}