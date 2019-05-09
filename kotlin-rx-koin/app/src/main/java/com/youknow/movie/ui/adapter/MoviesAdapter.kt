package com.youknow.movie.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.youknow.domain.model.SimpleMovie
import com.youknow.movie.R
import kotlinx.android.synthetic.main.item_movie.view.*


class MoviesAdapter(
    private val context: Context,
    private val movieClickListener: MovieClickListener,
    val movies: MutableList<SimpleMovie> = mutableListOf()
) : RecyclerView.Adapter<MoviesAdapter.MovieHolder>() {

    interface MovieClickListener {
        fun onMovieClick(movieId: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder =
        MovieHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = movies[position]

        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w500/${movie.posterPath}")
            .centerInside()
            .into(holder.itemView.ivPoster)
        holder.itemView.tvTitle.text = movie.title
        holder.itemView.tvRatingAvg.text = "${movie.voteAverage}"
        holder.itemView.tvReleaseDate.text = movie.releaseDate

        holder.itemView.setOnClickListener {
            movieClickListener.onMovieClick(movie.id.toString())
        }
    }

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}