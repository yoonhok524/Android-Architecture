package com.youknow.movie.domain.usecase.impl

import com.youknow.movie.domain.model.SimpleMovie
import com.youknow.movie.domain.repository.MoviesRepository
import androidx.lifecycle.LiveData
import com.youknow.movie.domain.usecase.GetNowPlayingMovies

class GetNowPlayingMoviesUsecase(private val moviesRepository: MoviesRepository) :
    GetNowPlayingMovies {

    override suspend fun get(): List<SimpleMovie> = moviesRepository.getNowPlaying()

}