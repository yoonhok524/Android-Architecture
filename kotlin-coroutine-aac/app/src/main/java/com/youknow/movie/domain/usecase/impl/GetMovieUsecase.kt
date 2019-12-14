package com.youknow.movie.domain.usecase

import com.youknow.movie.domain.model.Movie
import com.youknow.movie.domain.repository.MoviesRepository
import io.reactivex.Single

class GetMovieUsecase (private val moviesRepository: MoviesRepository): GetMovie {

    override fun get(id: String): Single<Movie> = moviesRepository.getMovie(id)

}