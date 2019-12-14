package com.youknow.movie.domain.usecase

import com.youknow.movie.domain.model.SimpleMovie
import io.reactivex.Single

interface GetUpcomingMovies {

    fun get(): Single<List<SimpleMovie>>

}