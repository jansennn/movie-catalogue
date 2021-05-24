package com.andreas.movie_catalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.andreas.movie_catalogue.utils.DataDummyTvShow

class TvShowViewModel : ViewModel() {
    fun getTvShow() = DataDummyTvShow.getTvShow()
}