package com.problemsolver.myorder.app.domain.use_cases

import com.problemsolver.myorder.app.domain.model.User
import com.problemsolver.myorder.app.domain.repository.StoreRepository
import javax.inject.Inject

class SetUser @Inject constructor(
	private val repository: StoreRepository,
) {
	operator fun invoke(user: User) {
		repository.setUser(user)
	}
}