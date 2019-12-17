package com.youknow.movie.data.source.cache

import com.youknow.movie.data.source.MoviesDataSource
import com.youknow.movie.domain.model.Movie
import com.youknow.movie.domain.model.SimpleMovie

class MoviesCacheDataSource: MoviesDataSource {

    override suspend fun getNowPlaying(): List<SimpleMovie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getUpcoming(): List<SimpleMovie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMovie(id: String): Movie {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}