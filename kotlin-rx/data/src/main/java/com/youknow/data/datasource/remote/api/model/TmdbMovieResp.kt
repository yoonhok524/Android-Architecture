package com.youknow.data.datasource.remote.api.model

import com.google.gson.annotations.SerializedName
import com.youknow.domain.model.Movie

data class TmdbMovieResp(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: String,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Float,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    @SerializedName("tagline")
    val tagLine: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Float,
    @SerializedName("vote_count")
    val voteCount: Int
)

data class Genre(
    val id: Int,
    val name: String
)

data class ProductionCompany(
    val name: String,
    val id: Int,
    @SerializedName("logo_path")
    val logoPath: String,
    @SerializedName("origin_country")
    val originCountry: String
)

data class ProductionCountry(
    val iso_3166_1: String,
    val name: String
)

data class SpokenLanguage(
    val iso_639_1: String,
    val name: String
)

fun TmdbMovieResp.mapToDomain(): Movie = Movie(
    adult = this.adult,
    backdropPath = this.backdropPath,
    budget = this.budget,
    genres = this.genres.map { it.name }.toList(),
    homepage = this.homepage,
    id = this.id,
    originalLanguage = this.originalLanguage,
    originalTitle = this.originalTitle,
    overview = this.overview,
    popularity = this.popularity,
    posterPath = this.posterPath,
    releaseDate = this.releaseDate,
    revenue = this.revenue,
    runtime = this.runtime,
    status = this.status,
    title = this.title,
    voteAverage = this.voteAverage,
    voteCount = this.voteCount
)