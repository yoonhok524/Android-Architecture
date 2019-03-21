package com.youknow.data.repository

import com.youknow.data.datasource.MoviesDataSource
import com.youknow.domain.model.Movie
import com.youknow.domain.model.SimpleMovie
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class MoviesRepositoryImplTest {

    @Mock
    private lateinit var moviesCacheDataSource: MoviesDataSource

    @Mock
    private lateinit var moviesRemoteDataSource: MoviesDataSource

    private lateinit var movieRepository: MoviesRepositoryImpl

    private val mockMovie1 =
        SimpleMovie("posterpath1", false, "overview1", "2019-03-01", 10, "hello world1", 10f, 10, 10f)
    private val mockMovie2 =
        SimpleMovie("posterpath2", true, "overview2", "2019-03-02", 20, "hello world2", 9f, 9, 9f)
    private val mockMovie3 =
        SimpleMovie("posterpath3", false, "overview3", "2019-03-03", 30, "hello world3",8f, 8, 8f)
    private val mockMovie4 =
        SimpleMovie("posterpath4", false, "overview4", "2019-03-04", 40, "hello world4",7f, 7, 7f)
    private val mockMovie5 =
        SimpleMovie("posterpath5", false, "overview5", "2019-03-05", 50, "hello world5", 6f, 6, 6f)

    private val mockMovie = Movie(
        adult = false,
        homepage = "homepage",
        id = 10,
        overview = "",
        popularity = 10f,
        posterPath = "",
        releaseDate = "",
        runtime = 100,
        status = "",
        title = "",
        voteAverage = 8.5f,
        voteCount = 10
    )

    private val nowPlayingList: List<SimpleMovie> = listOf(
        mockMovie1,
        mockMovie2,
        mockMovie3,
        mockMovie4,
        mockMovie5
    )

    private val exception = Exception()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        movieRepository = MoviesRepositoryImpl(moviesCacheDataSource, moviesRemoteDataSource)
    }

    @Test
    fun `getNowPlaying 정상 케이스`() {
        `when`(moviesRemoteDataSource.getNowPlaying()).thenReturn(Single.just(nowPlayingList))

        movieRepository.getNowPlaying()
            .test()
            .assertValue(nowPlayingList)
    }

    @Test
    fun `getNowPlaying 예외 케이스`() {
        `when`(moviesRemoteDataSource.getNowPlaying()).thenReturn(Single.error(exception))

        movieRepository.getNowPlaying()
            .test()
            .assertError(exception)
    }

    @Test
    fun `getMovie 정상 케이스`() {
        `when`(moviesRemoteDataSource.getMovie("10")).thenReturn(Single.just(mockMovie))

        movieRepository.getMovie("10")
            .test()
            .assertValue(mockMovie)
    }

    @Test
    fun `getMovie 예외 케이스`() {
        `when`(moviesRemoteDataSource.getMovie("10")).thenReturn(Single.error(exception))

        movieRepository.getMovie("10")
            .test()
            .assertError(exception)
    }
}