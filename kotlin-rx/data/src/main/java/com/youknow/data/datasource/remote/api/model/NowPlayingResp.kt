package com.youknow.data.datasource.remote.api.model

import com.google.gson.annotations.SerializedName
import com.youknow.domain.model.SimpleMovie

data class NowPlayingResp(
    val page: Int,
    val results: List<Result>,
    val dates: Dates,
    val totalPages: Int,
    val totalResults: Int
)

data class Result(
    @SerializedName("poster_path")
    val posterPath: String,
    val adult: Boolean,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    val title: String,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val popularity: Float,
    @SerializedName("vote_count")
    val voteCount: Int,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Float
)

data class Dates(
    val maximum: String,
    val minimum: String
)

fun NowPlayingResp.mapToDomain(): List<SimpleMovie> = results.map {
    SimpleMovie(
        posterPath = it.posterPath,
        adult = it.adult,
        overview = it.overview,
        releaseDate = it.releaseDate,
        id = it.id,
        originalTitle = it.originalTitle,
        originalLanguage = it.originalLanguage,
        title = it.title,
        backdropPath = it.backdropPath,
        popularity = it.popularity,
        voteCount = it.voteCount,
        voteAverage = it.voteAverage
    )
}.toList()