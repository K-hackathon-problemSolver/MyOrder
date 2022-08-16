package com.problemsolver.myorder.app.domain.use_cases

import com.problemsolver.myorder.app.data.remote.response.StoreDetailDTO
import com.problemsolver.myorder.app.domain.repository.StoreRepository
import com.problemsolver.myorder.app.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetStoreDetail @Inject constructor(
	private val repository: StoreRepository
) {
	operator fun invoke(id: String): Flow<Resource<StoreDetailDTO>> = flow {
		try {
			val response = repository.getStoreDetail(id)
			emit(Resource.Loading())
			emit(Resource.Success(response.body()!!))
		} catch(e: HttpException) {
			emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
		} catch(e: IOException) {
			emit(Resource.Error("Couldn't reach server. Check your internet connection."))
		}
	}
}