package com.herdal.paging3.presentation.characterdetails

import androidx.lifecycle.ViewModel
import com.herdal.paging3.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterDetailsViewModel @Inject constructor(private val repository: CharacterRepository) :
    ViewModel() {

}