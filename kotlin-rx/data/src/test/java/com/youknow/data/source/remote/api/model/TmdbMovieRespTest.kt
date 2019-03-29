package com.youknow.data.source.remote.api.model

import com.youknow.domain.model.Movie
import org.junit.Assert
import org.junit.Test

class TmdbMovieRespTest {

    private val tmdbMovieResp = TmdbMovieResp(
        adult= false,
        backdropPath= "b path",
        belongsToCollection= MovieCollection(1, "collection", "path", "backpath"),
        budget= 0,
        genres = listOf(Genre(111, "g1"), Genre(222, "g2")),
        homepage= "home page",
        id= 1,
        imdbId= "1",
        originalLanguage= "lang",
        originalTitle= "title",
        overview= "overview",
        popularity= 0f,
        posterPath= "path",
        productionCompanies= listOf(
            ProductionCompany("c1", 1, "logo path1", "country1"),
            ProductionCompany("c2", 2, "logo path2", "country2")),
        productionCountries= listOf(
            ProductionCountry("iso 1", "country 1"),
            ProductionCountry("iso 2", "country 2")
        ),
        releaseDate= "2019-03-01",
        revenue= 100,
        runtime= 200,
        spokenLanguages= listOf(
            SpokenLanguage("iso1", "spoken lang1"),
            SpokenLanguage("iso2", "spoken lang2")
        ),
        status= "a",
        tagLine= "s",
        title= "t",
        video= false,
        voteAverage= 5.5f,
        voteCount= 10
    )

    private val expected = Movie(
        adult = false,
        homepage = "home page",
        id = 1,
        overview = "overview",
        popularity = 0f,
        posterPath = "path",
        releaseDate = "2019-03-01",
        runtime = 200,
        status = "a",
        title = "t",
        voteAverage = 5.5f,
        voteCount = 10
    )

    @Test
    fun mapToDomainTest() {
        Assert.assertEquals(expected, tmdbMovieResp.mapToDomain())
    }

}