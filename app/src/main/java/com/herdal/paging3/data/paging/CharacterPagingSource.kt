package com.herdal.paging3.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.herdal.paging3.data.model.Character
import com.herdal.paging3.domain.repository.CharacterRepository

class CharacterPagingSource(
    private val repository: CharacterRepository
) : PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val pageNumber = params.key ?: 1
            val response = repository.getAllCharacters(pageNumber)
            val prevKey = if (pageNumber > 0) pageNumber - 1 else null
            val data = response.body()?.characters ?: emptyList()
            val responseData = mutableListOf<Character>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = pageNumber.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}