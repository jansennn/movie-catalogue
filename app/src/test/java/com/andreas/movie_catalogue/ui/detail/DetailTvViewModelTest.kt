package com.andreas.movie_catalogue.ui.detail

import com.andreas.movie_catalogue.utils.DataDummyTvShow
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailTvViewModelTest {
    private lateinit var viewModel: DetailTvViewModel
    private val dummyTv = DataDummyTvShow.getTvShow()[0]
    private val tvId = dummyTv.id


    @Before
    fun setUp(){
        viewModel = DetailTvViewModel()
        if (tvId != null) {
            viewModel.setSelectedTv(tvId)
        }
    }

    @Test
    fun getTv() {
        dummyTv.id?.let { viewModel.setSelectedTv(it) }
        val tvEntity = viewModel.getTv()
        assertNotNull(tvEntity)
        assertEquals(dummyTv.id, tvEntity.id)
        assertEquals(dummyTv.backdrop, tvEntity.backdrop)
        assertEquals(dummyTv.description, tvEntity.description)
        assertEquals(dummyTv.first_air, tvEntity.first_air)
        assertEquals(dummyTv.poster, tvEntity.poster)
        assertEquals(dummyTv.title, tvEntity.title)
    }
}