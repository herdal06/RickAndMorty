package com.herdal.paging3.domain.repository

import com.herdal.paging3.data.model.episode.EpisodeResponse
import retrofit2.Response

interface EpisodeRepository {
    suspend fun getAllEpisodes(page: Int): Response<EpisodeResponse>
}