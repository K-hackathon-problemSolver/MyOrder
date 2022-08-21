package com.problemsolver.myorder.app.domain.use_cases

import com.problemsolver.myorder.app._enums.OrderType
import com.problemsolver.myorder.app.data.remote.response.TypedOrderListDTO
import com.problemsolver.myorder.app.domain.repository.StoreRepository
import com.problemsolver.myorder.app.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTypedOrderList @Inject constructor(
	private val repository: StoreRepository
) {
	operator fun invoke(type: OrderType, id: String, size: Int, page: Int, sort: String?): Flow<Resource<List<TypedOrderListDTO>>> = flow {
		try {
			val response = repository.getTypedOrders(type, id, size, page, sort)
			emit(Resource.Loading())
			emit(Resource.Success(response.body()!!))
		} catch(e: HttpException) {
			emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
		} catch(e: IOException) {
			e.printStackTrace()
			emit(Resource.Error("Couldn't reach server. Check your internet connection."))
		}
	}
}