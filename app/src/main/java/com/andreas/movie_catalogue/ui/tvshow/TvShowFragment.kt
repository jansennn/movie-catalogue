package com.andreas.movie_catalogue.ui.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andreas.movie_catalogue.R
import com.andreas.movie_catalogue.data.TvShowEntity
import com.andreas.movie_catalogue.ui.detail.DetailTvShowActivity
import kotlinx.android.synthetic.main.fragment_tv_show.*


class TvShowFragment : Fragment() {
    private lateinit var viewModel: TvShowViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(TvShowViewModel::class.java)

        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showTvShow(viewModel.getTvShow())
    }


    fun showTvShow(list: ArrayList<TvShowEntity>){
        rv_tv.layoutManager = LinearLayoutManager(activity)
        val adapter = TvShowAdapter(list)
        rv_tv.adapter = adapter

        adapter.setOnItemClickCallback(object : TvShowAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TvShowEntity) {
                val moveWithObjectIntent = Intent(activity, DetailTvShowActivity::class.java)
                moveWithObjectIntent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, data.id)
                startActivity(moveWithObjectIntent)
            }
        })
    }
}