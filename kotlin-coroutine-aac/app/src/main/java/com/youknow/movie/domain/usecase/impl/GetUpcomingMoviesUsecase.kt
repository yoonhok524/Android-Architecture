package com.youknow.movie.domain.usecase.impl

import com.youknow.movie.domain.model.SimpleMovie
import com.youknow.movie.domain.repository.MoviesRepository
import androidx.lifecycle.LiveData
import com.youknow.movie.domain.usecase.GetUpcomingMovies

class GetUpcomingMoviesUsecase(private val moviesRepository: MoviesRepository) : GetUpcomingMovies {

    override suspend fun get(): List<SimpleMovie> = moviesRepository.getUpcoming()

}