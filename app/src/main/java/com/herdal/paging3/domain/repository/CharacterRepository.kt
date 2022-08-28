package com.herdal.paging3.domain.repository

import com.herdal.paging3.data.model.character.Character
import com.herdal.paging3.data.model.character.CharacterResponse
import retrofit2.Response

interface CharacterRepository {
    suspend fun getAllCharacters(page: Int): Response<CharacterResponse>
    suspend fun getCharacterById(characterId: Int): Response<Character>
}