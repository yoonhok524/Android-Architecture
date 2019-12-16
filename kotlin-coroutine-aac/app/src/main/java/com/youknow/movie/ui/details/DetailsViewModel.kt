package com.youknow.movie.ui.details

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.youknow.movie.data.repository.MoviesRepositoryImpl
import com.youknow.movie.data.source.cache.MoviesCacheDataSource
import com.youknow.movie.data.source.remote.MoviesRemoteDataSource
import com.youknow.movie.data.source.remote.api.MoviesApi
import com.youknow.movie.domain.model.Movie
import com.youknow.movie.domain.usecase.GetMovie
import com.youknow.movie.domain.usecase.impl.GetMovieUsecase
import kotlinx.coroutines.launch


class DetailsViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val TAG = DetailsViewModel::class.java.simpleName

    private val getMovie: GetMovie = GetMovieUsecase(
        MoviesRepositoryImpl(MoviesCacheDataSource(), MoviesRemoteDataSource(MoviesApi.service))
    )

    val movie: MutableLiveData<Movie> = MutableLiveData()

    fun getMovie(movieId: String) {
        viewModelScope.launch {
            Log.d(TAG, "[MOVIE] getMovie - $movieId")
            movie.value = getMovie.get(movieId)
        }
    }

}