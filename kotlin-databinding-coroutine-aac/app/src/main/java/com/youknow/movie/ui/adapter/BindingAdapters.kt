package com.youknow.movie.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.youknow.movie.R

@BindingAdapter("goneUnless")
fun setProgressBarVisibility(progressBar: ProgressBar, visibility: Boolean) {
    progressBar.visibility = if (visibility) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun loadImageByUrl(imageView: ImageView, url: String?) {
    Glide.with(imageView.context)
        .load("https://image.tmdb.org/t/p/w500/$url")
//        .placeholder(R.drawable.ic_movie)
        .into(imageView)
}