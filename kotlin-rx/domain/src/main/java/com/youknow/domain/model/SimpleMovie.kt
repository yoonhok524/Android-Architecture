package com.youknow.domain.model

data class SimpleMovie(
    val posterPath: String,
    val adult: Boolean,
    val overview: String,
    val releaseDate: String,
    val id: Int,
    val title: String,
    val popularity: Float,
    val voteCount: Int,
    val voteAverage: Float
)