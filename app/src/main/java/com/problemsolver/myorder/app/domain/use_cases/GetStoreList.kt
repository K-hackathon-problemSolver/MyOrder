package com.problemsolver.myorder.app.domain.use_cases

import com.problemsolver.myorder.app.data.remote.response.StoreDTO
import com.problemsolver.myorder.app.domain.repository.StoreListRepository
import com.problemsolver.myorder.app.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetStoreList @Inject constructor(
	private val repository: StoreListRepository
) {
	operator fun invoke(location: String, offset: Int, limit: Int): Flow<Resource<List<StoreDTO>>> = flow {
		try {
			val response = repository.getStoreList(location, offset, limit)
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