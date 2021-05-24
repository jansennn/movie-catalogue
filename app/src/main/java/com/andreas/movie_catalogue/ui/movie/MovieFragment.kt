package com.andreas.movie_catalogue.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andreas.movie_catalogue.R
import com.andreas.movie_catalogue.data.MovieEntity
import com.andreas.movie_catalogue.ui.detail.DetailMovieActivity
import kotlinx.android.synthetic.main.fragment_movie.*


class MovieFragment : Fragment() {
    private lateinit var viewModel: MovieViewModel
    private lateinit var listMovie: ArrayList<MovieEntity>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showMovie(viewModel.getMovies())
    }


    private fun showMovie(list: ArrayList<MovieEntity>){
        rv_movie.layoutManager = LinearLayoutManager(activity)
        val adapter = MovieAdapter(list)
        rv_movie.adapter = adapter
        adapter.notifyDataSetChanged()

        adapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MovieEntity) {
                val moveWithObjectIntent = Intent(activity, DetailMovieActivity::class.java)
                moveWithObjectIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, data.id)
                startActivity(moveWithObjectIntent)
            }
        })
    }
}