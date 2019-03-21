package com.youknow.domain.usecase

import com.youknow.domain.model.Movie
import io.reactivex.Single

interface GetMovie {

    fun get(id: String): Single<Movie>

}