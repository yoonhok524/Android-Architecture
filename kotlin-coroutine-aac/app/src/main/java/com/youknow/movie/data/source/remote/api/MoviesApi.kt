package com.youknow.movie.data.source.remote.api

import com.youknow.movie.BuildConfig
import com.youknow.movie.data.source.remote.api.model.NowPlayingResp
import com.youknow.movie.data.source.remote.api.model.TmdbMovieResp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("/3/movie/now_playing")
    suspend fun getMoviesNowPlaying(@Query("api_key") apiKey: String = BuildConfig.API_KEY): NowPlayingResp

    @GET("/3/movie/upcoming")
    suspend fun getMoviesUpcoming(@Query("api_key") apiKey: String = BuildConfig.API_KEY): NowPlayingResp

    @GET("/3/movie/{movieId}")
    suspend fun getMovie(@Path("movieId") movieId: String, @Query("api_key") apiKey: String = BuildConfig.API_KEY): TmdbMovieResp

    companion object {
        val service: MoviesApi by lazy {
            Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MoviesApi::class.java)
        }
    }

}
