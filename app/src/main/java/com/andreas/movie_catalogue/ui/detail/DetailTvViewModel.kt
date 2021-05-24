package com.andreas.movie_catalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.andreas.movie_catalogue.data.TvShowEntity
import com.andreas.movie_catalogue.utils.DataDummyTvShow

class DetailTvViewModel : ViewModel(){

    private lateinit var tvId: String

    fun setSelectedTv(tvId: String){
        this.tvId = tvId
    }

    fun getTv() : TvShowEntity {
        lateinit var tv: TvShowEntity
        val tvEntities = DataDummyTvShow.getTvShow()
        for (tvEntity in tvEntities){
            if(tvEntity.id == tvId){
                tv = tvEntity
            }
        }

        return tv
    }
}