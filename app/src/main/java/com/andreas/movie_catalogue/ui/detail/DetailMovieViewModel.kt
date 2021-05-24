package com.andreas.movie_catalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.andreas.movie_catalogue.data.MovieEntity
import com.andreas.movie_catalogue.utils.DataDummyMovie

class DetailMovieViewModel : ViewModel(){

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String){
        this.movieId = movieId
    }

    fun getMovie() : MovieEntity{
        lateinit var movie: MovieEntity
        val movieEntities = DataDummyMovie.getMovies()
        for (movieEntity in movieEntities){
            if(movieEntity.id == movieId){
                movie = movieEntity
            }
        }

        return movie
    }
}