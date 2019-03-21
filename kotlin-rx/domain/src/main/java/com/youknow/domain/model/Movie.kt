package com.youknow.domain.model

data class Movie (
    val adult: Boolean,
    val homepage: String,
    val id: Int,
    val overview: String,
    val popularity: Float,
    val posterPath: String,
    val releaseDate: String,
    val runtime: Int,
    val status: String,
    val title: String,
    val voteAverage: Float,
    val voteCount: Int
)