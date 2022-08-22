package com.herdal.paging3.data.model.episode

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Episode(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
) : Parcelable