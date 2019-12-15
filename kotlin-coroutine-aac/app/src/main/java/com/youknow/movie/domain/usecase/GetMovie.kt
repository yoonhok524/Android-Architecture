package com.youknow.movie.domain.usecase

import com.youknow.movie.domain.model.Movie

interface GetMovie {

    suspend fun get(id: String): Movie

}