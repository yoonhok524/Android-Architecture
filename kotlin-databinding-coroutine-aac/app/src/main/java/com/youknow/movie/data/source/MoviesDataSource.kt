package com.youknow.movie.data.source

import com.youknow.movie.domain.model.Movie
import com.youknow.movie.domain.model.SimpleMovie
import androidx.lifecycle.LiveData

interface MoviesDataSource {

    suspend fun getNowPlaying(): List<SimpleMovie>

    suspend fun getUpcoming(): List<SimpleMovie>

    suspend fun getMovie(id: String): Movie

}