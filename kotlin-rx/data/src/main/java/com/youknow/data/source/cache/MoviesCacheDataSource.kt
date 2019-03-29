package com.youknow.data.source.cache

import com.youknow.data.source.MoviesDataSource
import com.youknow.domain.model.Movie
import com.youknow.domain.model.SimpleMovie
import io.reactivex.Single

class MoviesCacheDataSource: MoviesDataSource {

    override fun getNowPlaying(): Single<List<SimpleMovie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovie(id: String): Single<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}