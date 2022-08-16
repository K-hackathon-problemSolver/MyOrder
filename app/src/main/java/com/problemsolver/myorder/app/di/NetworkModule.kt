package com.problemsolver.myorder.app.di

import com.problemsolver.myorder.app.data.remote.StoreApi
import com.problemsolver.myorder.app.data.repository.StoreRepositoryImpl
import com.problemsolver.myorder.app.domain.repository.StoreRepository
import com.problemsolver.myorder.app.domain.util.log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

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

	@Singleton
	@Provides
	fun provideLoggingInterceptor(): HttpLoggingInterceptor =
		HttpLoggingInterceptor() { it.log() }.setLevel(HttpLoggingInterceptor.Level.BODY)

	@Provides
	@Singleton
	fun provideOkHttpClient(
		interceptor: Interceptor,
		loggingInterceptor:HttpLoggingInterceptor
	): OkHttpClient {
		return OkHttpClient.Builder()
			.addInterceptor(interceptor)
			.addInterceptor(loggingInterceptor)
			.build()
	}

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
	fun provideStoreApi(retrofit: Retrofit): StoreApi {
		return retrofit.create(StoreApi::class.java)
	}

	@Provides
	@Singleton
	fun provideRecruitingsRepository(api: StoreApi): StoreRepository {
		return StoreRepositoryImpl(api)
	}


}