package com.problemsolver.myorder.app.presentation.BossCustomerSelect

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.problemsolver.myorder.app.domain.model.User
import com.problemsolver.myorder.app.domain.use_cases.GetUser
import com.problemsolver.myorder.app.domain.use_cases.SetUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectorViewModel @Inject constructor(
	val getUser: GetUser,
	val setUser: SetUser,
): ViewModel() {

	private var user = mutableStateOf(User())

	fun onSelected(isCustomer: Boolean) {
		viewModelScope.launch {
			getUser().collect() { user.value = it }
			user.value.type = if(isCustomer) "customer" else "store"
			setUser(user.value)
		}
	}
}