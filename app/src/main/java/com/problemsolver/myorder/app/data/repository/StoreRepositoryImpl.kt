package com.problemsolver.myorder.app.data.repository

import com.problemsolver.myorder.app._enums.OrderType
import com.problemsolver.myorder.app.data.remote.StoreApi
import com.problemsolver.myorder.app.data.remote.request.TypedOrderBodyDTO
import com.problemsolver.myorder.app.data.remote.response.StoreDTO
import com.problemsolver.myorder.app.data.remote.response.StoreDetailDTO
import com.problemsolver.myorder.app.data.remote.response.TypedOrderListDTO
import com.problemsolver.myorder.app.data.storage.UserStore
import com.problemsolver.myorder.app.domain.model.User
import com.problemsolver.myorder.app.domain.repository.StoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import retrofit2.Response
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
	private val api: StoreApi,
	private val store: UserStore
): StoreRepository {
	override suspend fun getStoreList(location: String, offset: Int, limit: Int): Response<List<StoreDTO>> {
		return api.getStoreList(location, offset, limit)
	}
	override suspend fun getStoreDetail(id: String): Response<StoreDetailDTO> {
		return api.getStoreDetail(id)
	}
	override suspend fun getTypedOrders(type: OrderType, id: String, size: Int, page: Int, sort: String?): Response<List<TypedOrderListDTO>> {
		return api.getTypedOrders(
			type.value,
			TypedOrderBodyDTO(id, size, page, sort)
		)
	}

	override fun getUser(): User {
		return runBlocking(Dispatchers.IO) {
			store.getUser().first()
		}
	}

	override fun setUser(user: User) {
		runBlocking(Dispatchers.IO) {
			store.setUser(user)
		}
	}
}