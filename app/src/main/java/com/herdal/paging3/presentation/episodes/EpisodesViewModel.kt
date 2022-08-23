package com.herdal.paging3.presentation.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.herdal.paging3.data.paging.EpisodePagingSource
import com.herdal.paging3.domain.repository.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(private val repository: EpisodeRepository) :
    ViewModel() {
    val listData = Pager(PagingConfig(pageSize = 1)) {
        EpisodePagingSource(repository)
    }.flow.cachedIn(viewModelScope)
}