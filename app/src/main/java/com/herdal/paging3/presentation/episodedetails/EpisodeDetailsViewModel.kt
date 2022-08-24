package com.herdal.paging3.presentation.episodedetails

import androidx.lifecycle.ViewModel
import com.herdal.paging3.domain.repository.CharacterRepository
import com.herdal.paging3.domain.repository.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailsViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository,
    private val characterRepository: CharacterRepository
) : ViewModel() {
}