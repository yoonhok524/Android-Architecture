package com.youknow.movie.ui.upcoming

import androidx.lifecycle.*
import com.youknow.movie.data.repository.MoviesRepositoryImpl
import com.youknow.movie.data.source.cache.MoviesCacheDataSource
import com.youknow.movie.data.source.remote.MoviesRemoteDataSource
import com.youknow.movie.data.source.remote.api.MoviesApi
import com.youknow.movie.domain.model.SimpleMovie
import com.youknow.movie.domain.usecase.impl.GetUpcomingMoviesUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpcomingViewModel(
    private val getMovies: GetUpcomingMoviesUsecase = GetUpcomingMoviesUsecase(
        MoviesRepositoryImpl(MoviesCacheDataSource(), MoviesRemoteDataSource(MoviesApi.service))
    )
) : ViewModel() {

    private val TAG = UpcomingViewModel::class.java.simpleName

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    val movies: LiveData<List<SimpleMovie>> = liveData {
        isLoading.value = true

        withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(getMovies.get())
        }

        isLoading.value = false
    }

}