package com.youknow.movie.domain.repository

import com.youknow.movie.domain.model.Movie
import com.youknow.movie.domain.model.SimpleMovie

interface MoviesRepository {

    suspend fun getNowPlaying(): List<SimpleMovie>

    suspend fun getUpcoming(): List<SimpleMovie>

    suspend fun getMovie(id: String): Movie
}