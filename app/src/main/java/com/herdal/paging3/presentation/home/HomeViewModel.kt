package com.herdal.paging3.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.herdal.paging3.data.paging.CharacterPagingSource
import com.herdal.paging3.domain.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: CharacterRepository) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        CharacterPagingSource(repository)
    }.flow.cachedIn(viewModelScope)
}