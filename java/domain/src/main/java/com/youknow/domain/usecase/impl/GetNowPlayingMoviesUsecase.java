package com.youknow.domain.usecase.impl;

import com.youknow.domain.model.SimpleMovie;
import com.youknow.domain.repository.MoviesRepository;
import com.youknow.domain.usecase.GetNowPlayingMovies;

import android.util.Log;

import java.util.List;

public class GetNowPlayingMoviesUsecase implements GetNowPlayingMovies {

    private static final String TAG = "GetNowPlayingMoviesUsec";

    private MoviesRepository moviesRepository;

    public GetNowPlayingMoviesUsecase(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Override
    public void get(final GetMoviesCallback callback) {
        Log.d(TAG, "[Y.M.] getMovies");
        moviesRepository.getMovies(new MoviesRepository.MoviesLoadedCallback() {
            @Override
            public void onMoviesLoaded(List<SimpleMovie> movies) {
                callback.onMoviesLoaded(movies);
            }
        });
    }
}
