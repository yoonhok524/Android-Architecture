package com.youknow.data.source.remote.api.model

import com.google.gson.annotations.SerializedName
import com.youknow.domain.model.Movie

data class TmdbMovieResp(
    val adult: Boolean = false,
    @SerializedName("backdrop_path")
    val backdropPath: String = "",
    @SerializedName("belongs_to_collection")
    val belongsToCollection: MovieCollection = MovieCollection(),
    val budget: Int = 0,
    val genres: List<Genre> = listOf(),
    val homepage: String? = "",
    val id: Int = 0,
    @SerializedName("imdb_id")
    val imdbId: String = "",
    @SerializedName("original_language")
    val originalLanguage: String = "",
    @SerializedName("original_title")
    val originalTitle: String = "",
    val overview: String = "",
    val popularity: Float = 0f,
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany> = listOf(),
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry> = listOf(),
    @SerializedName("release_date")
    val releaseDate: String = "",
    val revenue: Long = 0L,
    val runtime: Int = 0,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage> = listOf(),
    val status: String = "",
    @SerializedName("tagline")
    val tagLine: String = "",
    val title: String = "",
    val video: Boolean = false,
    @SerializedName("vote_average")
    val voteAverage: Float = 0f,
    @SerializedName("vote_count")
    val voteCount: Int = 0
)

data class MovieCollection(
    val id: Int = 0,
    val name: String = "",
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("backdrop_path")
    val backdropPath: String = ""
)

data class Genre(
    val id: Int = 0,
    val name: String = ""
)

data class ProductionCompany(
    val name: String = "",
    val id: Int = 0,
    @SerializedName("logo_path")
    val logoPath: String = "",
    @SerializedName("origin_country")
    val originCountry: String = ""
)

data class ProductionCountry(
    val iso_3166_1: String = "",
    val name: String = ""
)

data class SpokenLanguage(
    val iso_639_1: String = "",
    val name: String = ""
)

fun TmdbMovieResp.mapToDomain(): Movie = Movie(
    adult = this.adult,
    genres = this.genres.map { it.name }.toList(),
    homepage = this.homepage ?: "",
    id = this.id,
    overview = this.overview,
    popularity = this.popularity,
    posterPath = this.posterPath,
    releaseDate = this.releaseDate,
    runtime = this.runtime,
    status = this.status,
    tagline = this.tagLine,
    title = this.title,
    voteAverage = this.voteAverage,
    voteCount = this.voteCount
)