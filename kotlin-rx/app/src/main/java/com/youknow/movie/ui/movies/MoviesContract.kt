package com.youknow.movie.ui.movies

import com.youknow.domain.model.SimpleMovie

interface MoviesContract {
    interface View {
        fun showProgressBar(visibility: Int)
        fun onMoviesLoaded(movies: List<SimpleMovie>)
        fun onError(msgResId: Int)
        fun hideError()

    }

    interface Presenter {
        fun unsubscribe()
        fun getMoviesNowPlaying()

    }
}