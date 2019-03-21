package com.youknow.data.datasource.remote.api

import com.youknow.data.datasource.remote.api.model.NowPlayingResp
import com.youknow.data.datasource.remote.api.model.TmdbMovieResp
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val API_KEY = "8728476f04abf3f446e9e4068d443b54"

interface MoviesApi {

    @GET("/3/movie/now_playing")
    fun getMoviesNowPlaying(@Query("api_key") apiKey: String): Single<NowPlayingResp>

    @GET("/3/movie/{movieId}")
    fun getMovie(@Path("movieId") movieId: String, @Query("api_key") apiKey: String): Single<TmdbMovieResp>

    companion object {
        fun getService(): MoviesApi {
            val client: OkHttpClient = OkHttpClient.Builder().apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }.build()

            val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(MoviesApi::class.java)
        }
    }

}
