package com.youknow.domain.model

data class Movie (
    val adult: Boolean,
    val backdropPath: String,
    val budget: Int,
    val genres: List<String>,
    val homepage: String,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Float,
    val posterPath: String,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val title: String,
    val voteAverage: Float,
    val voteCount: Int
)