package com.problemsolver.myorder.app.data.remote

import com.problemsolver.myorder.app.data.remote.response.StoreDTO
import com.problemsolver.myorder.app.data.remote.response.StoreDetailDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface StoreApi {

	// 가게 리스트
	@Headers("Content-Type: application/json")
	@GET("/store/list")
	suspend fun getStoreList(
		@Query("location") location: String?,
		@Query("offset") offset: Int?,
		@Query("limit") limit: Int?,
	): Response<List<StoreDTO>>

	// 가게 상세 페이지
	@Headers("Content-Type: application/json")
	@GET("/store")
	suspend fun getStoreDetail(
		@Query("id") id: String?
	): Response<StoreDetailDTO>

}