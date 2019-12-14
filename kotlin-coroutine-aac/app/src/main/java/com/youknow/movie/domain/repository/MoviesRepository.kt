package com.youknow.movie.domain.repository

import com.youknow.movie.domain.model.Movie
import com.youknow.movie.domain.model.SimpleMovie
import io.reactivex.Single

interface MoviesRepository {

    fun getNowPlaying(): Single<List<SimpleMovie>>

    fun getUpcoming(): Single<List<SimpleMovie>>

    fun getMovie(id: String): Single<Movie>
}