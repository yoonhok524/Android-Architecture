package com.youknow.movie.ui.upcoming

import com.youknow.domain.model.SimpleMovie

interface UpcomingContract {
    interface View {
        fun showProgressBar(visible: Int)
        fun hideError()
        fun onError(msgResId: Int)
        fun onMoviesLoaded(movies: List<SimpleMovie>)
    }

    interface Presenter {
        fun unsubscribe()
        fun getUpcomingMovies()
    }
}