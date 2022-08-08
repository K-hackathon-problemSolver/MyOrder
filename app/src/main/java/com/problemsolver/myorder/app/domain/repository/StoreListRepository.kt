package com.problemsolver.myorder.app.domain.repository

import com.problemsolver.myorder.app.data.remote.dto.StoreDTO
import com.problemsolver.myorder.app.data.remote.dto.StoreListBodyDTO
import retrofit2.Response

interface StoreListRepository {
	suspend fun getStoreList(storeListBody: StoreListBodyDTO): Response<List<StoreDTO>>
}