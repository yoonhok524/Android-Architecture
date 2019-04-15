package com.youknow.movie.ui.nowplaying

import com.youknow.domain.model.SimpleMovie

interface NowPlayingContract {
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