package com.youknow.domain.repository

import com.youknow.domain.model.Movie
import com.youknow.domain.model.SimpleMovie
import io.reactivex.Single

interface MoviesRepository {

    fun getNowPlaying(): Single<List<SimpleMovie>>

    fun getUpcoming(): Single<List<SimpleMovie>>

    fun getMovie(id: String): Single<Movie>
}