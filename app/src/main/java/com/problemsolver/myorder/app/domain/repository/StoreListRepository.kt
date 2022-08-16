package com.problemsolver.myorder.app.domain.repository

import com.problemsolver.myorder.app.data.remote.response.StoreDTO
import retrofit2.Response

interface StoreListRepository {
	suspend fun getStoreList(location: String, offset: Int, limit: Int): Response<List<StoreDTO>>
}