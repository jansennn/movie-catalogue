package com.andreas.movie_catalogue.ui.detail

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.andreas.movie_catalogue.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_detail_tv_show.*

class DetailTvShowActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailTvViewModel::class.java]

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
            val tvId = extras.getString(DetailTvShowActivity.EXTRA_TV_SHOW)
            if(tvId != null){
                viewModel.setSelectedTv(tvId)
                val tv = viewModel.getTv()
                tvName.text = tv.title
                tvTitle.text = tv.title
                tvFirstAir.text = tv.first_air
                tvDeskripsi.text = tv.description

                Glide.with(this)
                    .load(tv.backdrop)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgCover)

                Glide.with(this)
                    .load(tv.poster)
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