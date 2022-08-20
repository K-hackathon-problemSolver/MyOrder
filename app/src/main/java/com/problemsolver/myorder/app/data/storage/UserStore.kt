package com.problemsolver.myorder.app.data.storage

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.problemsolver.myorder.app.domain.model.User
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore by preferencesDataStore("user")

class UserStore @Inject constructor(@ApplicationContext context: Context) {
	private val store = context.dataStore

	suspend fun setUser(user: User) {
		store.edit {
			it[USER_UUID] = user.uuid
			it[USER_TOKEN] = user.token
			it[USER_TYPE] = user.type
		}
	}

	fun getUser(): Flow<User> {
		return store.data.map {
			User(
				it[USER_UUID]!!,
				it[USER_TOKEN]!!,
				it[USER_TYPE]!!
			)
		}
	}

	companion object {
		private val USER_UUID = stringPreferencesKey("uuid")
		private val USER_TOKEN = stringPreferencesKey("token")
		private val USER_TYPE = stringPreferencesKey("type")
	}
}