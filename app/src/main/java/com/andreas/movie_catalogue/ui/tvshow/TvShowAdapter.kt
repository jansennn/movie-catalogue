package com.andreas.movie_catalogue.ui.tvshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andreas.movie_catalogue.R
import com.andreas.movie_catalogue.data.TvShowEntity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.item_row_tv_show.view.*

class TvShowAdapter(val listTvShOW: ArrayList<TvShowEntity>) : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): TvShowAdapter.TvShowViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_tv_show, viewGroup, false)
        return TvShowViewHolder(view)
    }

    override fun getItemCount(): Int = listTvShOW.size

    override fun onBindViewHolder(holder: TvShowAdapter.TvShowViewHolder, position: Int) {
        holder.bind(listTvShOW[position])
    }

    inner class TvShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShowEntity: TvShowEntity) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(tvShowEntity.poster)
                    .placeholder(R.drawable.ic_image)
                    .transform(RoundedCorners(16))
                    .into(imgPhoto)

                itemView.tvTitle.text = tvShowEntity.title
                itemView.tvDesc.text = tvShowEntity.description
                itemView.tvFirstAir.text = tvShowEntity.first_air
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(tvShowEntity) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TvShowEntity)
    }

}