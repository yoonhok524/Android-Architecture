package com.youknow.movie.data.source.remote

import com.youknow.movie.BuildConfig
import com.youknow.movie.data.source.MoviesDataSource
import com.youknow.movie.data.source.remote.api.MoviesApi
import com.youknow.movie.data.source.remote.api.model.mapToDomain
import com.youknow.movie.domain.model.Movie
import com.youknow.movie.domain.model.SimpleMovie
import io.reactivex.Single

class MoviesRemoteDataSource(
    private val api: MoviesApi
) : MoviesDataSource {

    override fun getNowPlaying(): Single<List<SimpleMovie>> = api.getMoviesNowPlaying(BuildConfig.API_KEY)
        .map { it.mapToDomain() }

    override fun getUpcoming(): Single<List<SimpleMovie>> = api.getMoviesUpcoming(BuildConfig.API_KEY)
        .map { it.mapToDomain() }

    override fun getMovie(id: String): Single<Movie> = api.getMovie(id, BuildConfig.API_KEY)
        .map { it.mapToDomain() }

}