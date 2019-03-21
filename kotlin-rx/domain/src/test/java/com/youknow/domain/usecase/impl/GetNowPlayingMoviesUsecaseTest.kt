package com.youknow.domain.usecase.impl

import com.youknow.domain.model.SimpleMovie
import com.youknow.domain.repository.MoviesRepository
import com.youknow.domain.usecase.GetNowPlayingMovies
import com.youknow.domain.usecase.GetNowPlayingMoviesUsecase
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetNowPlayingMoviesUsecaseTest {

    @Mock
    private lateinit var movieRepository: MoviesRepository

    private lateinit var getNowPlayingMoviesUsecase: GetNowPlayingMovies

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getNowPlayingMoviesUsecase = GetNowPlayingMoviesUsecase(movieRepository)
    }

    @Test
    fun `get 정상 케이스`() {
        val movieList = listOf(
            SimpleMovie(
                posterPath = "path1",
                adult = false,
                releaseDate = "2019-03-01",
                id = 1,
                title = "title 1",
                voteAverage = 5.1f
            ),
            SimpleMovie(
                posterPath = "path2",
                adult = true,
                releaseDate = "2019-03-02",
                id = 2,
                title = "title 2",
                voteAverage = 5.2f
            ),
            SimpleMovie(
                posterPath = "path3",
                adult = false,
                releaseDate = "2019-03-03",
                id = 3,
                title = "title 3",
                voteAverage = 5.3f
            )
        )

        `when`(movieRepository.getNowPlaying()).thenReturn(Single.just(movieList))

        getNowPlayingMoviesUsecase.get()
            .test()
            .assertValue(movieList)
    }

    @Test
    fun `get 예외 케이스`() {
        val exception = Exception()
        `when`(movieRepository.getNowPlaying()).thenReturn(Single.error(exception))

        getNowPlayingMoviesUsecase.get()
            .test()
            .assertError(exception)
    }
}