package com.herdal.paging3.di

import com.herdal.paging3.data.repository.CharacterRepositoryImpl
import com.herdal.paging3.data.service.ApiService
import com.herdal.paging3.domain.repository.CharacterRepository
import com.herdal.paging3.utils.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl() = ApiConstants.BASE_URL

    @Provides
    @Singleton
    fun provideCharacterRepository(apiService: ApiService): CharacterRepository {
        return CharacterRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(BASE_URL: String): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}