package com.youknow.data.datasource.remote.api.model

import com.google.gson.annotations.SerializedName
import com.youknow.domain.model.SimpleMovie

data class NowPlayingResp(
    val page: Int = 0,
    val results: List<Result> = listOf(),
    val dates: Dates = Dates(),
    val totalPages: Int = 0,
    val totalResults: Int = 0
)

data class Result(
    @SerializedName("poster_path")
    val posterPath: String = "",
    val adult: Boolean = false,
    val overview: String = "",
    @SerializedName("release_date")
    val releaseDate: String = "",
    @SerializedName("genre_ids")
    val genreIds: List<Int> = listOf(),
    val id: Int = 0,
    @SerializedName("original_title")
    val originalTitle: String = "",
    @SerializedName("original_language")
    val originalLanguage: String = "",
    val title: String = "",
    @SerializedName("backdrop_path")
    val backdropPath: String = "",
    val popularity: Float = 0f,
    @SerializedName("vote_count")
    val voteCount: Int = 0,
    val video: Boolean = false,
    @SerializedName("vote_average")
    val voteAverage: Float = 0f
)

data class Dates(
    val maximum: String = "",
    val minimum: String = ""
)

fun NowPlayingResp.mapToDomain(): List<SimpleMovie> = results.map {
    SimpleMovie(
        posterPath = it.posterPath,
        adult = it.adult,
        overview = it.overview,
        releaseDate = it.releaseDate,
        id = it.id,
        title = it.title,
        popularity = it.popularity,
        voteCount = it.voteCount,
        voteAverage = it.voteAverage
    )
}.toList()