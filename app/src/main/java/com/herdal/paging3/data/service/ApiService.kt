package com.herdal.paging3.data.service

import com.herdal.paging3.data.model.character.CharacterResponse
import com.herdal.paging3.data.model.episode.EpisodeResponse
import com.herdal.paging3.utils.ApiConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(ApiConstants.Endpoints.CHARACTER)
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): Response<CharacterResponse>

    @GET(ApiConstants.Endpoints.EPISODE)
    suspend fun getAllEpisodes(
        @Query("page") page: Int
    ): Response<EpisodeResponse>

    @GET("character/{character-id}")
    suspend fun getCharacterById(
        @Path("character-id") characterId: Int
    ): Response<CharacterResponse>
}