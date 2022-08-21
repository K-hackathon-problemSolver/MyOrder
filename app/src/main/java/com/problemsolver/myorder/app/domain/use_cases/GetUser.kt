package com.problemsolver.myorder.app.domain.use_cases

import com.problemsolver.myorder.app.domain.model.User
import com.problemsolver.myorder.app.domain.repository.StoreRepository
import com.problemsolver.myorder.app.domain.util.log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUser @Inject constructor(
	private val repository: StoreRepository,
) {
	operator fun invoke(): Flow<User> = flow {
		try {
			emit(repository.getUser())
		} catch(e: Exception) {
			"ERRROR: usecase GetToken form dataStore".log()
			emit(User(""))
		}
	}
}