package com.youknow.movie.data.api;

import com.youknow.movie.data.api.model.TmdbMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbService {

    @GET("/movie/now_playing")
    Call<NowPlaying> getMoviesNowPlaying(@Query("api_key") String apiKey);

    @GET("/movie/{movieId}")
    Call<TmdbMovie> getMovie(@Query("api_key") String apiKey, @Path("movieId") String movieId);

}
