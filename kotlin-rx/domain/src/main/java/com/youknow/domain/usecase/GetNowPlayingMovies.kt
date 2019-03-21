package com.youknow.domain.usecase

import com.youknow.domain.model.SimpleMovie
import io.reactivex.Single

interface GetNowPlayingMovies {

    fun get(): Single<List<SimpleMovie>>

}