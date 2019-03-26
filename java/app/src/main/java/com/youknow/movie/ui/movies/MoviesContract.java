package com.youknow.movie.ui.movies;

import com.youknow.domain.model.SimpleMovie;

import java.util.List;

public interface MoviesContract {

    interface View {
        void onMoviesLoaded(List<SimpleMovie> movies);
    }

    interface Presenter {
        void getMovies();
    }
}
