package com.herdal.paging3.data.repository

import com.herdal.paging3.data.model.character.Character
import com.herdal.paging3.data.model.character.CharacterResponse
import com.herdal.paging3.data.service.ApiService
import com.herdal.paging3.domain.repository.CharacterRepository
import retrofit2.Response

class CharacterRepositoryImpl(private val apiService: ApiService) : CharacterRepository {
    override suspend fun getAllCharacters(page: Int): Response<CharacterResponse> =
        apiService.getAllCharacters(page)

    override suspend fun getCharacterById(characterId: Int): Response<Character> =
        apiService.getCharacterById(characterId)
}