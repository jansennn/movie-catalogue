package com.andreas.movie_catalogue.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MovieEntity(
    var id: String?,
    var title: String?,
    var description: String?,
    var duration: String?,
    var category: String?,
    var poster: Int?
) : Parcelable