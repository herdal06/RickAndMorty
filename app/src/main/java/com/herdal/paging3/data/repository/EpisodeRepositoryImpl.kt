package com.herdal.paging3.data.repository

import com.herdal.paging3.data.model.episode.EpisodeResponse
import com.herdal.paging3.data.service.ApiService
import com.herdal.paging3.domain.repository.EpisodeRepository
import retrofit2.Response

class EpisodeRepositoryImpl(private val apiService: ApiService) : EpisodeRepository {
    override suspend fun getAllEpisodes(page: Int): Response<EpisodeResponse> =
        apiService.getAllEpisodes(page)
}