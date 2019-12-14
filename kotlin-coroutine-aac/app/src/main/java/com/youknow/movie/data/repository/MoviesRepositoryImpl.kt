package com.youknow.movie.data.repository

import com.youknow.movie.data.source.MoviesDataSource
import com.youknow.movie.domain.model.Movie
import com.youknow.movie.domain.model.SimpleMovie
import com.youknow.movie.domain.repository.MoviesRepository
import io.reactivex.Single

class MoviesRepositoryImpl(
    private val moviesCacheDataSource: MoviesDataSource,
    private val moviesRemoteDataSource: MoviesDataSource
): MoviesRepository {

    override fun getNowPlaying(): Single<List<SimpleMovie>> = moviesRemoteDataSource.getNowPlaying()

    override fun getUpcoming(): Single<List<SimpleMovie>> = moviesRemoteDataSource.getUpcoming()

    override fun getMovie(id: String): Single<Movie> = moviesRemoteDataSource.getMovie(id)

}