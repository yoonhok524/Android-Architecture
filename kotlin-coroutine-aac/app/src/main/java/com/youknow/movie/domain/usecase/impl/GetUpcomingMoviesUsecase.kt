package com.youknow.movie.domain.usecase

import com.youknow.movie.domain.model.SimpleMovie
import com.youknow.movie.domain.repository.MoviesRepository
import io.reactivex.Single

class GetUpcomingMoviesUsecase(private val moviesRepository: MoviesRepository) : GetUpcomingMovies {

    override fun get(): Single<List<SimpleMovie>> = moviesRepository.getUpcoming()

}