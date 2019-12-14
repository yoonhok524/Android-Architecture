package com.youknow.movie.domain.usecase

import com.youknow.movie.domain.model.Movie
import io.reactivex.Single

interface GetMovie {

    fun get(id: String): Single<Movie>

}