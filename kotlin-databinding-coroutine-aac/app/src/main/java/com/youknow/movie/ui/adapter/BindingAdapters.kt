package com.youknow.movie.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@BindingAdapter("goneUnless")
fun setProgressBarVisibility(progressBar: ProgressBar, visibility: Boolean) {
    progressBar.visibility = if (visibility) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun loadImageByUrl(imageView: ImageView, url: String?) {
    url?.let {
        Glide.with(imageView.context)
            .load("https://image.tmdb.org/t/p/w500/$it")
            .into(imageView)
    }
}

@BindingAdapter("genres")
fun genres(recyclerView: RecyclerView, genres: List<String>?) {
    genres?.let {
        (recyclerView.adapter as GenreAdapter?)?.let { adapter ->
            adapter.genres.clear()
            adapter.genres.addAll(it)
        }
    }
}

@BindingAdapter("contentsVisibility")
fun setContentsVisibility(container: ConstraintLayout, isLoading: Boolean) {
    container.visibility = if (isLoading) View.GONE else View.VISIBLE
}