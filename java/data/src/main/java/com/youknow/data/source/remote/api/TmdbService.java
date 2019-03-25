package com.youknow.data.source.remote.api;

import com.youknow.data.source.remote.api.model.NowPlayingResp;
import com.youknow.data.source.remote.api.model.TmdbMovieResp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbService {

    @GET("/movie/now_playing")
    Call<NowPlayingResp> getMoviesNowPlaying(@Query("api_key") String apiKey);

    @GET("/movie/{movieId}")
    Call<TmdbMovieResp> getMovie(@Query("api_key") String apiKey, @Path("movieId") String movieId);

}
