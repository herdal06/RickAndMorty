package com.herdal.paging3.utils.extensions

import android.widget.ImageView
import coil.load

fun ImageView.loadImage(url: String?) {
    this.load(url) {
        crossfade(true)
        crossfade(1000)
    }
}