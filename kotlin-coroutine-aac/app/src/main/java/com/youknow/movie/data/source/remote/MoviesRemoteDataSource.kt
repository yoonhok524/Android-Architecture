package com.youknow.movie.data.source.remote

import com.youknow.movie.data.source.MoviesDataSource
import com.youknow.movie.data.source.remote.api.MoviesApi
import com.youknow.movie.data.source.remote.api.model.mapToDomain
import com.youknow.movie.domain.model.Movie
import com.youknow.movie.domain.model.SimpleMovie

class MoviesRemoteDataSource(
    private val api: MoviesApi
) : MoviesDataSource {

    override suspend fun getNowPlaying(): List<SimpleMovie> = api.getMoviesNowPlaying()
        .mapToDomain()

    override suspend fun getUpcoming(): List<SimpleMovie> = api.getMoviesUpcoming()
        .mapToDomain()

    override suspend fun getMovie(id: String): Movie = api.getMovie(id)
        .mapToDomain()

}