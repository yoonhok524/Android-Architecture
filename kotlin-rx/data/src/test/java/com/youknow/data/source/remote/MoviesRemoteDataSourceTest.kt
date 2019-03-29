package com.youknow.data.source.remote

import com.youknow.data.BuildConfig
import com.youknow.data.source.remote.api.MoviesApi
import com.youknow.data.source.remote.api.model.NowPlayingResp
import com.youknow.data.source.remote.api.model.TmdbMovieResp
import com.youknow.data.source.remote.api.model.mapToDomain
import com.youknow.domain.model.Movie
import com.youknow.domain.model.SimpleMovie
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class MoviesRemoteDataSourceTest {
    @Mock
    private lateinit var mockApi: MoviesApi

    private lateinit var moviesRemoteDataSource: MoviesRemoteDataSource

    private val nowPlayingResp = NowPlayingResp()
    private val nowPlayingList: List<SimpleMovie> = nowPlayingResp.mapToDomain()
    private val tmdbMovieResp = TmdbMovieResp()
    private val movie = Movie()
    private val exception = Exception()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        moviesRemoteDataSource = MoviesRemoteDataSource(mockApi)
    }


    @Test
    fun `getNowPlaying 정상 케이스`() {
        `when`(mockApi.getMoviesNowPlaying(BuildConfig.API_KEY)).thenReturn(Single.just(nowPlayingResp))

        moviesRemoteDataSource.getNowPlaying()
            .test()
            .assertValue(nowPlayingList)
    }

    @Test
    fun `getNowPlaying 예외 케이스`() {
        `when`(mockApi.getMoviesNowPlaying(BuildConfig.API_KEY)).thenReturn(Single.error(exception))

        moviesRemoteDataSource.getNowPlaying()
            .test()
            .assertError(exception)
    }

    @Test
    fun `getMovie 정상 케이스`() {
        `when`(mockApi.getMovie("10", BuildConfig.API_KEY)).thenReturn(Single.just(tmdbMovieResp))

        moviesRemoteDataSource.getMovie("10")
            .test()
            .assertValue(movie)
    }

    @Test
    fun `getMovie 예외 케이스`() {
        `when`(mockApi.getMovie("10", BuildConfig.API_KEY)).thenReturn(Single.error(exception))

        moviesRemoteDataSource.getMovie("10")
            .test()
            .assertError(exception)
    }
}