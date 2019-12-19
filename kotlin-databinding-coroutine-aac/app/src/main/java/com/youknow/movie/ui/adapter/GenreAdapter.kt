package com.youknow.movie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.youknow.movie.R
import com.youknow.movie.databinding.ItemGenreBinding

class GenreAdapter(
    val genres: MutableList<String> = mutableListOf()
) : RecyclerView.Adapter<GenreAdapter.GenreHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreHolder = GenreHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_genre,
            parent,
            false
        )
    )

    override fun getItemCount(): Int = genres.size

    override fun onBindViewHolder(holder: GenreHolder, position: Int) {
        holder.binding.genre = genres[position]
    }

    class GenreHolder(val binding: ItemGenreBinding) : RecyclerView.ViewHolder(binding.root)
}