package com.youknow.domain.model

data class SimpleMovie(
    val posterPath: String,
    val adult: Boolean,
    val overview: String,
    val releaseDate: String,
    val id: Int,
    val originalTitle: String,
    val originalLanguage: String,
    val title: String,
    val backdropPath: String,
    val popularity: Float,
    val voteCount: Int,
    val voteAverage: Float
)