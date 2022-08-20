package com.problemsolver.myorder.app.domain.repository

import com.problemsolver.myorder.app._enums.OrderType
import com.problemsolver.myorder.app.data.remote.response.StoreDTO
import com.problemsolver.myorder.app.data.remote.response.StoreDetailDTO
import com.problemsolver.myorder.app.data.remote.response.TypedOrderListDTO
import retrofit2.Response

interface StoreRepository {
	suspend fun getStoreList(location: String, offset: Int, limit: Int): Response<List<StoreDTO>>
	suspend fun getStoreDetail(id: String): Response<StoreDetailDTO>
	suspend fun getTypedOrders(type: OrderType, id: String, size: Int, page: Int, sort: String?): Response<List<TypedOrderListDTO>>
}