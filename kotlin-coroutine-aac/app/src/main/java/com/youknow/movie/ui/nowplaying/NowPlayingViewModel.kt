package com.youknow.movie.ui.nowplaying

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.youknow.movie.data.repository.MoviesRepositoryImpl
import com.youknow.movie.data.source.cache.MoviesCacheDataSource
import com.youknow.movie.data.source.remote.MoviesRemoteDataSource
import com.youknow.movie.data.source.remote.api.MoviesApi
import com.youknow.movie.domain.usecase.GetNowPlayingMovies
import com.youknow.movie.domain.usecase.impl.GetNowPlayingMoviesUsecase
import kotlinx.coroutines.Dispatchers

class NowPlayingViewModel(
    private val getMovies: GetNowPlayingMovies = GetNowPlayingMoviesUsecase(MoviesRepositoryImpl(MoviesCacheDataSource(), MoviesRemoteDataSource(MoviesApi.service)))
) : ViewModel() {

    val movies = liveData(Dispatchers.IO) {
        emit(getMovies.get())
    }

    private val TAG = NowPlayingViewModel::class.java.simpleName

    fun getMoviesNowPlaying() {
//        view.showProgressBar(View.VISIBLE)
//        view.hideError()

//        view.showProgressBar(View.GONE)
//        if (movies.isNullOrEmpty()) {
//            view.onError(R.string.err_movies_not_exists)
//        } else {
//            view.onMoviesLoaded(movies)
//        }

//        view.showProgressBar(View.GONE)
//        view.onError(R.string.err_get_movies_failed)
//        Log.e(TAG, "[Y.M.] getMoviesNowPlaying - failed: ${t.message}", t)
    }

}