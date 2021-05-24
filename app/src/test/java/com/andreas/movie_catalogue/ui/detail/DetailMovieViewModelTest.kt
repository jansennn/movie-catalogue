package com.andreas.movie_catalogue.ui.detail

import com.andreas.movie_catalogue.utils.DataDummyMovie
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummyMovie.getMovies()[0]
    private val movieId = dummyMovie.id

    @Before
    fun setUp(){
        viewModel = DetailMovieViewModel()
        if (movieId != null) {
            viewModel.setSelectedMovie(movieId)
        }
    }



    @Test
    fun getMovie() {
        dummyMovie.id?.let { viewModel.setSelectedMovie(it) }
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.poster, movieEntity.poster)
        assertEquals(dummyMovie.category, movieEntity.category)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.duration, movieEntity.duration)

    }
}