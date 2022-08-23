package com.herdal.paging3.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.herdal.paging3.data.model.episode.Episode
import com.herdal.paging3.domain.repository.EpisodeRepository

class EpisodePagingSource(
    private val repository: EpisodeRepository
) : PagingSource<Int, Episode>() {
    override fun getRefreshKey(state: PagingState<Int, Episode>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Episode> =
        try {
            val pageNumber = params.key ?: 1
            val response = repository.getAllEpisodes(pageNumber)
            val prevKey = if (pageNumber == 1) null else -1
            val data = response.body()?.results ?: emptyList()
            val responseData = mutableListOf<Episode>()
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