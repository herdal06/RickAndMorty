package com.herdal.paging3.presentation.episodedetails

import androidx.lifecycle.ViewModel
import com.herdal.paging3.domain.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailsViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
}