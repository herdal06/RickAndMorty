package com.herdal.paging3.data.service

import com.herdal.paging3.data.model.CharacterResponse
import com.herdal.paging3.utils.ApiConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(ApiConstants.Endpoints.CHARACTER)
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): Response<CharacterResponse>
}