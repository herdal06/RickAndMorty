package com.herdal.paging3.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val origin: Origin,
    val type: String,
    val url: String,
    val location: Location,
) : Parcelable