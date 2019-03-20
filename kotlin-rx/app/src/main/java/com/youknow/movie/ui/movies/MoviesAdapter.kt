package com.youknow.movie.ui.movies

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.youknow.domain.model.SimpleMovie
import com.youknow.movie.R
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(
    private val context: Context,
    val movies: MutableList<SimpleMovie> = mutableListOf()
) : RecyclerView.Adapter<MoviesAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder =
        MovieHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = movies[position]

        Glide.with(context).load("https://image.tmdb.org/t/p/w500/${movie.posterPath}").into(holder.itemView.ivPoster)
        holder.itemView.tvTitle.text = movie.title
        holder.itemView.tvRatingAvg.text = "${movie.voteAverage}"
        holder.itemView.tvReleaseDate.text = movie.releaseDate
    }

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}