package com.youknow.movie.ui.nowplaying

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.youknow.movie.data.repository.MoviesRepositoryImpl
import com.youknow.movie.data.source.cache.MoviesCacheDataSource
import com.youknow.movie.data.source.remote.MoviesRemoteDataSource
import com.youknow.movie.data.source.remote.api.MoviesApi
import com.youknow.movie.domain.usecase.GetNowPlayingMovies
import com.youknow.movie.domain.usecase.impl.GetNowPlayingMoviesUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NowPlayingViewModel(
    private val getMovies: GetNowPlayingMovies = GetNowPlayingMoviesUsecase(
        MoviesRepositoryImpl(MoviesCacheDataSource(), MoviesRemoteDataSource(MoviesApi.service))
    )
) : ViewModel() {

    private val TAG = NowPlayingViewModel::class.java.simpleName

    val isLoading = MutableLiveData<Boolean>(false)

    val movies = liveData {
        isLoading.value = true

        withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(getMovies.get())
        }

        isLoading.value = false
    }

}