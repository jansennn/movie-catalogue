package com.andreas.movie_catalogue.ui.detail

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.andreas.movie_catalogue.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_detail_movie_activity.*

class DetailMovieActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie_activity)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(
                this,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                false
            )
            window.statusBarColor = Color.TRANSPARENT
        }

        toolbar.title = ""
        setSupportActionBar(toolbar)
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val extras = intent.extras
        if(extras != null){
            val movieId = extras.getString(EXTRA_MOVIE)
            if(movieId != null){
                viewModel.setSelectedMovie(movieId)
                val movie = viewModel.getMovie()
                Log.d("TAG", movie.toString())
                tvName.text = movie.title
                tvTitle.text = movie.title
                tvCat.text = movie.category
                tvDesc.text = movie.description
                tvDur.text = movie.duration

                Glide.with(this)
                    .load(movie.poster)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgCover)

                Glide.with(this)
                    .load(movie.poster)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgPhoto)
            }
        }
    }

    fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
        val window = activity.window
        val winParams = window.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        window.attributes = winParams
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}