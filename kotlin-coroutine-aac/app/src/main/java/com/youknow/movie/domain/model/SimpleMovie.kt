package com.youknow.movie.domain.model

data class SimpleMovie(
    val posterPath: String,
    val adult: Boolean,
    val releaseDate: String,
    val id: Int,
    val title: String,
    val voteAverage: Float
)