package com.herdal.paging3.presentation.home

import androidx.lifecycle.ViewModel
import com.herdal.paging3.domain.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: CharacterRepository) : ViewModel() {

}