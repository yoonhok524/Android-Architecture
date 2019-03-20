package com.youknow.domain.usecase

import com.youknow.domain.model.Movie
import com.youknow.domain.model.SimpleMovie
import com.youknow.domain.repository.MoviesRepository
import io.reactivex.Single

class GetMovieUsecase (private val moviesRepository: MoviesRepository) {

    fun get(id: String): Single<Movie> = moviesRepository.getMovie(id)

}