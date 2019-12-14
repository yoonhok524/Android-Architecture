package com.youknow.movie.data.source.cache

import com.youknow.movie.data.source.MoviesDataSource
import com.youknow.movie.domain.model.Movie
import com.youknow.movie.domain.model.SimpleMovie
import io.reactivex.Single

class MoviesCacheDataSource: MoviesDataSource {

    override fun getNowPlaying(): Single<List<SimpleMovie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUpcoming(): Single<List<SimpleMovie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovie(id: String): Single<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}