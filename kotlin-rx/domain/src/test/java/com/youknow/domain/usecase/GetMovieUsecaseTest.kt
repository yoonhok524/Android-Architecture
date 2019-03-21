package com.youknow.domain.usecase

import com.youknow.domain.model.Movie
import com.youknow.domain.repository.MoviesRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetMovieUsecaseTest {

    @Mock
    private lateinit var movieRepository: MoviesRepository

    private lateinit var getMovieUsecase: GetMovieUsecase

    private val mockId = "10"

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getMovieUsecase = GetMovieUsecase(movieRepository)
    }

    @Test
    fun `get 정상 케이스`() {
        val mockMovie = Movie(
            adult = false,
            homepage = "home",
            id = 1,
            overview = "overview",
            popularity = 1f,
            posterPath = "path",
            releaseDate = "2019-03-01",
            runtime = 1,
            status = "released",
            title = "hello world",
            voteAverage = 9.5f,
            voteCount = 1
        )

        `when`(movieRepository.getMovie(mockId)).thenReturn(Single.just(mockMovie))

        getMovieUsecase.get(mockId)
            .test()
            .assertValue(mockMovie)
    }

    @Test
    fun `get 예외 케이스`() {
        val exception = Exception()
        `when`(movieRepository.getMovie(mockId)).thenReturn(Single.error(exception))

        getMovieUsecase.get(mockId)
            .test()
            .assertError(exception)
    }
}