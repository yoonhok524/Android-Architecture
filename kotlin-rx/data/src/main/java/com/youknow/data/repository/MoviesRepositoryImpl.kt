package com.youknow.data.repository

import com.youknow.data.datasource.MoviesDataSource
import com.youknow.data.datasource.cache.MoviesCacheDataSource
import com.youknow.domain.model.Movie
import com.youknow.domain.model.SimpleMovie
import com.youknow.domain.repository.MoviesRepository
import io.reactivex.Single

class MoviesRepositoryImpl(
    private val moviesCacheDataSource: MoviesDataSource,
    private val moviesRemoteDataSource: MoviesDataSource
): MoviesRepository {

    override fun getNowPlaying(): Single<List<SimpleMovie>> = moviesRemoteDataSource.getNowPlaying()

    override fun getMovie(id: String): Single<Movie> = moviesRemoteDataSource.getMovie(id)

}