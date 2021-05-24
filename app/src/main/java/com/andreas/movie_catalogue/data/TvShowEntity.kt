package com.andreas.movie_catalogue.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowEntity(
    var id: String?,
    var title: String?,
    var description: String?,
    var first_air: String?,
    var backdrop: String?,
    var poster: String?
) : Parcelable