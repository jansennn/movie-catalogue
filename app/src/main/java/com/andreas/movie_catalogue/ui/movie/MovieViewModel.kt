package com.andreas.movie_catalogue.ui.movie


import androidx.lifecycle.ViewModel
import com.andreas.movie_catalogue.utils.DataDummyMovie

class MovieViewModel : ViewModel() {
    fun getMovies() = DataDummyMovie.getMovies()
}