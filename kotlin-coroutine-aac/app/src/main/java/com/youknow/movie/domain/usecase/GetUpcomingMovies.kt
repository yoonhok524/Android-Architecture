package com.youknow.movie.domain.usecase

import com.youknow.movie.domain.model.SimpleMovie
import androidx.lifecycle.LiveData

interface GetUpcomingMovies {
    suspend fun get(): List<SimpleMovie>

}