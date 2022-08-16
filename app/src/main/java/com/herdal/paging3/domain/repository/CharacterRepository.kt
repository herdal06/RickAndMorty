package com.herdal.paging3.domain.repository

import com.herdal.paging3.data.model.CharacterResponse
import retrofit2.Response

interface CharacterRepository {
    suspend fun getAllCharacters(page: Int): Response<CharacterResponse>
}