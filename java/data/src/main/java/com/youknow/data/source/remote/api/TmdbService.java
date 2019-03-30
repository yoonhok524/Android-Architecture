package com.youknow.data.source.remote.api;

import com.youknow.data.source.remote.api.model.NowPlayingResp;
import com.youknow.data.source.remote.api.model.TmdbMovieResp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbService {

    String API_KEY = "8728476f04abf3f446e9e4068d443b54";

    @GET("/3/movie/now_playing")
    Call<NowPlayingResp> getMoviesNowPlaying(@Query("api_key") String apiKey);

    @GET("/3/movie/{movieId}?api_key=")
    Call<TmdbMovieResp> getMovie(@Query("api_key") String apiKey, @Path("movieId") String movieId);

}
