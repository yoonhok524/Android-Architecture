package com.youknow.domain.usecase;

import com.youknow.domain.model.Movie;

public interface GetMovie {

    interface GetMovieCallback {
        void onMovieLoaded(Movie movie);
    }

    void get(String movieId, GetMovieCallback callback);
}
