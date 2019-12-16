package com.youknow.movie.ui.upcoming

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.youknow.movie.data.repository.MoviesRepositoryImpl
import com.youknow.movie.data.source.cache.MoviesCacheDataSource
import com.youknow.movie.data.source.remote.MoviesRemoteDataSource
import com.youknow.movie.data.source.remote.api.MoviesApi
import com.youknow.movie.domain.model.SimpleMovie
import com.youknow.movie.domain.usecase.impl.GetUpcomingMoviesUsecase
import kotlinx.coroutines.Dispatchers


class UpcomingViewModel(
    private val getMovies: GetUpcomingMoviesUsecase = GetUpcomingMoviesUsecase(
        MoviesRepositoryImpl(MoviesCacheDataSource(), MoviesRemoteDataSource(MoviesApi.service))
    )
) : ViewModel() {

    private val TAG = UpcomingViewModel::class.java.simpleName

    val movies: LiveData<List<SimpleMovie>> = liveData(Dispatchers.IO) {
        emit(getMovies.get())
    }

}