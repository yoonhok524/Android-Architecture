package com.youknow.movie.ui.details

import com.youknow.domain.model.Movie

interface DetailsContract {
    interface View {
        fun showProgressBar(visibility: Int)
        fun onMovieLoaded(movie: Movie)
        fun onError(msgResId: Int)
        fun hideError()
    }

    interface Presenter {
        fun unsubscribe()
        fun getMovie(movieId: String)

    }
}