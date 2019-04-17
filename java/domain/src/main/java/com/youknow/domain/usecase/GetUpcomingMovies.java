package com.youknow.domain.usecase;

import com.youknow.domain.model.SimpleMovie;

import java.util.List;

public interface GetUpcomingMovies {

    interface GetMoviesCallback {
        void onMoviesLoaded(List<SimpleMovie> movies);
    }

    void get(GetMoviesCallback callback);
}
