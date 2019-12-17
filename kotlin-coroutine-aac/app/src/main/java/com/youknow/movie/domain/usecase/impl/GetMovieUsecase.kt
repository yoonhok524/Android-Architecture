package com.youknow.movie.domain.usecase.impl

import com.youknow.movie.domain.model.Movie
import com.youknow.movie.domain.repository.MoviesRepository
import com.youknow.movie.domain.usecase.GetMovie

class GetMovieUsecase(private val moviesRepository: MoviesRepository) : GetMovie {

    override suspend fun get(id: String): Movie = moviesRepository.getMovie(id)

}