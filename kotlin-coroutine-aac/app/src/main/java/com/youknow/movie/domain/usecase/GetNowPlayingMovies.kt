package com.youknow.movie.domain.usecase

import com.youknow.movie.domain.model.SimpleMovie

interface GetNowPlayingMovies {

    suspend fun get(): List<SimpleMovie>

}