package com.youknow.data.datasource.remote.api.model

import com.youknow.domain.model.SimpleMovie
import org.junit.Assert.assertEquals
import org.junit.Test

class NowPlayingRespTest {

    private val result1 = Result(
        posterPath = "path 1",
        adult = false,
        overview = "overview 1",
        releaseDate = "2019-03-01",
        genreIds = listOf(1, 2),
        id = 1,
        originalTitle = "title 1",
        originalLanguage = "lang 1",
        title = "1",
        backdropPath = "backdrop path 1",
        popularity = 1f,
        voteCount = 1,
        video = false,
        voteAverage = 1f
    )

    private val result2 = Result(
        posterPath = "path 2",
        adult = true,
        overview = "overview 2",
        releaseDate = "2019-03-02",
        genreIds = listOf(2, 3),
        id = 2,
        originalTitle = "title 2",
        originalLanguage = "lang 2",
        title = "2",
        backdropPath = "backdrop path 2",
        popularity = 2f,
        voteCount = 2,
        video = true,
        voteAverage = 2f
    )

    private val result3 = Result(
        posterPath = "path 3",
        adult = true,
        overview = "overview 3",
        releaseDate = "2019-03-03",
        genreIds = listOf(4),
        id = 3,
        originalTitle = "title 3",
        originalLanguage = "lang 3",
        title = "3",
        backdropPath = "backdrop path 3",
        popularity = 3f,
        voteCount = 3,
        video = false,
        voteAverage = 3f
    )

    private val nowPlayingResp = NowPlayingResp(
        page = 1,
        results = listOf(result1, result2, result3),
        dates = Dates("max", "min"),
        totalPages = 1,
        totalResults = 3
    )

    @Test
    fun mapToDomainTest() {
        val expected: List<SimpleMovie> = listOf(
            SimpleMovie("path 1", false, "overview 1", "2019-03-01", 1, "1", 1f, 1, 1f),
            SimpleMovie("path 2", true, "overview 2", "2019-03-02", 2, "2", 2f, 2, 2f),
            SimpleMovie("path 3", true, "overview 3", "2019-03-03", 3, "3", 3f, 3, 3f)
        )

        assertEquals(expected, nowPlayingResp.mapToDomain())
    }

}