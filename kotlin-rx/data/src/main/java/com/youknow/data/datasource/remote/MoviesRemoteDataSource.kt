package com.youknow.data.datasource.remote

import com.youknow.data.datasource.MoviesDataSource
import com.youknow.data.datasource.remote.api.MoviesApi
import com.youknow.data.datasource.remote.api.model.mapToDomain
import com.youknow.domain.model.Movie
import com.youknow.domain.model.SimpleMovie
import io.reactivex.Single

class MoviesRemoteDataSource(
    private val api: MoviesApi
): MoviesDataSource {

    override fun getNowPlaying(): Single<List<SimpleMovie>> = api.getMoviesNowPlaying("8728476f04abf3f446e9e4068d443b54")
        .map { it.mapToDomain() }

    override fun getMovie(id: String): Single<Movie> = api.getMovie("8728476f04abf3f446e9e4068d443b54", id)
        .map { it.mapToDomain() }

}