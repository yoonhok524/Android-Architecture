package com.youknow.domain.usecase;

import com.youknow.domain.model.SimpleMovie;

import java.util.List;

public interface GetNowPlayingMovies {

    interface GetMoviesCallback {
        void onMoviesLoaded(List<SimpleMovie> movies);
    }

    void get(GetMoviesCallback callback);
}
