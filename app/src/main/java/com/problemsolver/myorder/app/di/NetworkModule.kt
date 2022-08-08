package com.problemsolver.myorder.app.di

import com.problemsolver.myorder.app.data.remote.StoreListApi
import com.problemsolver.myorder.app.data.repository.StoreListRepositoryImpl
import com.problemsolver.myorder.app.domain.repository.StoreListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

	@Provides
	@Singleton
	fun provideRetrofit(client: OkHttpClient): Retrofit {
		return Retrofit.Builder()
//            .baseUrl(RemoteConstant.BASE_URL)
			.baseUrl("http://ec2-13-124-200-247.ap-northeast-2.compute.amazonaws.com/")
			.addConverterFactory(GsonConverterFactory.create())
			.client(client)
			.build()
	}

	@Provides
	@Singleton
	fun provideStoreListApi(retrofit: Retrofit): StoreListApi {
		return retrofit.create(StoreListApi::class.java)
	}

	@Provides
	@Singleton
	fun provideRecruitingsRepository(api: StoreListApi): StoreListRepository {
		return StoreListRepositoryImpl(api)
	}

	@Provides
	@Singleton
	fun provideOkHttpClient(
		interceptor: Interceptor
	): OkHttpClient {
		return OkHttpClient.Builder()
			.addInterceptor(interceptor)
			.build()
	}

	@Provides
	@Singleton
	fun provideAuthInterceptor(): Interceptor = Interceptor{ chain ->
		val newRequest = chain
			.request()
			.newBuilder()
			.addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhY2Nlc3NfdG9rZW4iLCJpYXQiOjE2NTk5MjI2MTQsImV4cCI6MTY2MDAwOTAxNCwibWVtYmVyVHlwZSI6IkNVU1RPTUVSIn0.FZZ9tASECxMtpqZ6QqTSw1d8nIUpz0wB6cz7PpuAmcc")
			.build()
		return@Interceptor chain.proceed(newRequest)
	}
}