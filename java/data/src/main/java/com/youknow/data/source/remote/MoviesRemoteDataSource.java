package com.youknow.data.source.remote;

import android.util.Log;

import com.youknow.data.source.MoviesDataSource;
import com.youknow.data.source.remote.api.TmdbService;
import com.youknow.data.source.remote.api.model.NowPlayingResp;
import com.youknow.data.source.remote.api.model.TmdbMovieResp;
import com.youknow.domain.repository.MoviesRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesRemoteDataSource implements MoviesDataSource {

    private TmdbService tmdbService;

    public MoviesRemoteDataSource(TmdbService tmdbService) {
        this.tmdbService = tmdbService;
    }

    @Override
    public void getNowPlaying(final MoviesRepository.MoviesLoadedCallback callback) {
        tmdbService.getMoviesNowPlaying(TmdbService.API_KEY).enqueue(new Callback<NowPlayingResp>() {
            @Override
            public void onResponse(Call<NowPlayingResp> call, Response<NowPlayingResp> response) {
                if (response.body() != null) {
                    callback.onMoviesLoaded(NowPlayingResp.mapToDomain(response.body()));
                }
            }

            @Override
            public void onFailure(Call<NowPlayingResp> call, Throwable throwable) {

            }
        });
    }

    @Override
    public void getUpcoming(final MoviesRepository.MoviesLoadedCallback callback) {
        tmdbService.getMoviesUpcoming(TmdbService.API_KEY).enqueue(new Callback<NowPlayingResp>() {
            @Override
            public void onResponse(Call<NowPlayingResp> call, Response<NowPlayingResp> response) {
                if (response.body() != null) {
                    callback.onMoviesLoaded(NowPlayingResp.mapToDomain(response.body()));
                }
            }

            @Override
            public void onFailure(Call<NowPlayingResp> call, Throwable throwable) {

            }
        });
    }

    @Override
    public void getMovie(String movieId, final MoviesRepository.MovieLoadedCallback callback) {
        Log.d("Test", "[Movie] getMovie - movieId: " + movieId);
        tmdbService.getMovie(movieId, TmdbService.API_KEY).enqueue(new Callback<TmdbMovieResp>() {
            @Override
            public void onResponse(Call<TmdbMovieResp> call, Response<TmdbMovieResp> response) {
                if (response.body() != null) {
                    callback.onMovieLoaded(TmdbMovieResp.mapToDomain(response.body()));
                } else {
                    Log.e("Test", "[Movie] getMovie - failed");
                }
            }

            @Override
            public void onFailure(Call<TmdbMovieResp> call, Throwable throwable) {
                Log.e("Test", "[Movie] getMovie - failed: " + throwable.getMessage());
                throwable.printStackTrace();
            }
        });
    }
}
