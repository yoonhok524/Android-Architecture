package com.youknow.data.source.remote

import com.youknow.data.BuildConfig
import com.youknow.data.source.MoviesDataSource
import com.youknow.data.source.remote.api.MoviesApi
import com.youknow.data.source.remote.api.model.mapToDomain
import com.youknow.domain.model.Movie
import com.youknow.domain.model.SimpleMovie
import io.reactivex.Single

class MoviesRemoteDataSource(
    private val api: MoviesApi
) : MoviesDataSource {

    override fun getNowPlaying(): Single<List<SimpleMovie>> = api.getMoviesNowPlaying(BuildConfig.API_KEY)
        .map { it.mapToDomain() }

    override fun getMovie(id: String): Single<Movie> = api.getMovie(id, BuildConfig.API_KEY)
        .map { it.mapToDomain() }

}