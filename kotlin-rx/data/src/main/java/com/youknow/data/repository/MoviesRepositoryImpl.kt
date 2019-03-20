package com.youknow.data.repository

import com.youknow.data.datasource.MoviesDataSource
import com.youknow.domain.model.Movie
import com.youknow.domain.model.SimpleMovie
import com.youknow.domain.repository.MoviesRepository
import io.reactivex.Single

class MoviesRepositoryImpl(
    private val moviesDataSource: MoviesDataSource
): MoviesRepository {

    override fun getNowPlaying(): Single<List<SimpleMovie>> = moviesDataSource.getNowPlaying()

    override fun getMovie(id: String): Single<Movie> = moviesDataSource.getMovie(id)

}