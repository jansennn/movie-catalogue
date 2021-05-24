package com.andreas.movie_catalogue.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andreas.movie_catalogue.R
import com.andreas.movie_catalogue.data.MovieEntity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.item_row_movie.view.*

class MovieAdapter(val listMovie: ArrayList<MovieEntity>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder {
        val view =  LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_movie, viewGroup, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int  = listMovie.size

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movieEntity: MovieEntity) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(movieEntity.poster)
                    .placeholder(R.drawable.ic_image)
                    .transform(RoundedCorners(16))
                    .into(imgPhoto)

                itemView.tvTitle.text = movieEntity.title
                itemView.tvDuration.text = movieEntity.duration
                itemView.tvCategory.text = movieEntity.category
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(movieEntity) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MovieEntity)
    }
}