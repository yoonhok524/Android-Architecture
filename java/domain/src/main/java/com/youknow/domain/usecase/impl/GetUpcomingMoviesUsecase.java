package com.youknow.domain.usecase.impl;

import android.util.Log;

import com.youknow.domain.model.SimpleMovie;
import com.youknow.domain.repository.MoviesRepository;
import com.youknow.domain.usecase.GetUpcomingMovies;

import java.util.List;

public class GetUpcomingMoviesUsecase implements GetUpcomingMovies {

    private static final String TAG = "GetUpcomingMoviesUsec";

    private MoviesRepository moviesRepository;

    public GetUpcomingMoviesUsecase(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Override
    public void get(final GetMoviesCallback callback) {
        Log.d(TAG, "[Y.M.] getNowPlaying");
        moviesRepository.getUpcoming(new MoviesRepository.MoviesLoadedCallback() {
            @Override
            public void onMoviesLoaded(List<SimpleMovie> movies) {
                callback.onMoviesLoaded(movies);
            }
        });
    }
}
