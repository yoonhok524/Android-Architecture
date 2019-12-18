package com.youknow.movie.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.youknow.movie.R
import kotlinx.android.synthetic.main.item_genre.view.*

class GenreAdapter(
    private val genres: List<String> = listOf()
) : RecyclerView.Adapter<GenreAdapter.GenreHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreHolder =
        GenreHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_genre,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = genres.size

    override fun onBindViewHolder(holder: GenreHolder, position: Int) {
        holder.itemView.tvGenre.text = genres[position]
    }

    class GenreHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}