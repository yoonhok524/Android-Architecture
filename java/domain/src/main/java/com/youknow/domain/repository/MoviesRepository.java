package com.youknow.domain.repository;

import com.youknow.domain.model.Movie;
import com.youknow.domain.model.SimpleMovie;

import java.util.List;

public interface MoviesRepository {

    interface MoviesLoadedCallback {
        void onMoviesLoaded(List<SimpleMovie> movies);
    }

    interface MovieLoadedCallback {
        void onMovieLoaded(Movie movie);
    }

    void getMovies(MoviesLoadedCallback callback);

    void getMovie(String movieId, MovieLoadedCallback callback);

}
