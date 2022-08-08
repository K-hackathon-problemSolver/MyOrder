package com.problemsolver.myorder.app.data.repository

import com.problemsolver.myorder.app.data.remote.StoreListApi
import com.problemsolver.myorder.app.data.remote.dto.StoreDTO
import com.problemsolver.myorder.app.data.remote.dto.StoreListBodyDTO
import com.problemsolver.myorder.app.domain.repository.StoreListRepository
import retrofit2.Response
import javax.inject.Inject

class StoreListRepositoryImpl @Inject constructor(
	private val api: StoreListApi
): StoreListRepository {
	override suspend fun getStoreList(storeListBody: StoreListBodyDTO): Response<List<StoreDTO>> {
		return api.getStoreList(storeListBody)
	}
}