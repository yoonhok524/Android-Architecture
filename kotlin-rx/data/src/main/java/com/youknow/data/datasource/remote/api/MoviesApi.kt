package com.youknow.data.datasource.remote.api

import com.youknow.data.datasource.remote.api.model.NowPlayingResp
import com.youknow.data.datasource.remote.api.model.TmdbMovieResp
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Retrofit



interface MoviesApi {

    @GET("/movie/now_playing")
    fun getMoviesNowPlaying(@Query("api_key") apiKey: String): Single<NowPlayingResp>

    @GET("/movie/{movieId}")
    fun getMovie(@Query("api_key") apiKey: String, @Path("movieId") movieId: String): Single<TmdbMovieResp>

    companion object {
        fun getService(): MoviesApi {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .build()

            return retrofit.create(MoviesApi::class.java)
        }
    }

}
