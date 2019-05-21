package com.youknow.data.source.remote.api.model

import com.youknow.domain.model.SimpleMovie
import org.junit.Assert.assertEquals
import org.junit.Test

class NowPlayingRespTest {

    private val result1 = Result(
        posterPath = "path 1",
        adult = false,
        releaseDate = "2019-03-01",
        id = 1,
        title = "1",
        voteAverage = 1f
    )

    private val result2 = Result(
        posterPath = "path 2",
        adult = true,
        releaseDate = "2019-03-02",
        id = 2,
        title = "2",
        voteAverage = 2f
    )

    private val result3 = Result(
        posterPath = "path 3",
        adult = true,
        releaseDate = "2019-03-03",
        id = 3,
        title = "3",
        voteAverage = 3f
    )

    private val nowPlayingResp = NowPlayingResp(
        results = listOf(result1, result2, result3)
    )

    @Test
    fun mapToDomainTest() {
        val expected: List<SimpleMovie> = listOf(
            SimpleMovie("path 1", false, "2019-03-01", 1, "1", 1f),
            SimpleMovie("path 2", true,  "2019-03-02", 2, "2", 2f),
            SimpleMovie("path 3", true, "2019-03-03", 3, "3", 3f)
        )

        assertEquals(expected, nowPlayingResp.mapToDomain())
    }

}