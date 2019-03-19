package com.youknow.movie.ui.movies;

import com.youknow.domain.model.Movie;

import java.util.List;

public interface MoviesContract {

    interface View {
        void onMoviesLoaded(List<Movie> movies);
    }

    interface Presenter {
        void getMovies();
    }
}
