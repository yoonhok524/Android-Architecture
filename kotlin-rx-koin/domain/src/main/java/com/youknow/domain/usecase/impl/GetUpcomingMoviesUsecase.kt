package com.youknow.domain.usecase

import com.youknow.domain.model.SimpleMovie
import com.youknow.domain.repository.MoviesRepository
import io.reactivex.Single

class GetUpcomingMoviesUsecase(private val moviesRepository: MoviesRepository) : GetUpcomingMovies {

    override fun get(): Single<List<SimpleMovie>> = moviesRepository.getUpcoming()

}