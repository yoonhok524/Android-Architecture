package com.youknow.domain.usecase

import com.youknow.domain.model.SimpleMovie
import com.youknow.domain.repository.MoviesRepository
import io.reactivex.Single

class GetNowPlayingMoviesUsecase (private val moviesRepository: MoviesRepository): GetNowPlayingMovies {

    override fun get(): Single<List<SimpleMovie>> {
        return moviesRepository.getNowPlaying()
    }

}