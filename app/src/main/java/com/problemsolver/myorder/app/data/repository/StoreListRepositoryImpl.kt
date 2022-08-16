package com.problemsolver.myorder.app.data.repository

import com.problemsolver.myorder.app.data.remote.StoreListApi
import com.problemsolver.myorder.app.data.remote.response.StoreDTO
import com.problemsolver.myorder.app.domain.repository.StoreListRepository
import retrofit2.Response
import javax.inject.Inject

class StoreListRepositoryImpl @Inject constructor(
	private val api: StoreListApi
): StoreListRepository {
	override suspend fun getStoreList(location: String, offset: Int, limit: Int): Response<List<StoreDTO>> {
		return api.getStoreList(location, offset, limit)
	}
}