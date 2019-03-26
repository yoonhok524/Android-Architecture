package com.youknow.movie.ui.movies;

import com.youknow.domain.model.SimpleMovie;
import com.youknow.domain.usecase.GetNowPlayingMovies;

import java.util.List;

public class MoviesPresenter implements MoviesContract.Presenter {

    private MoviesContract.View view;
    private GetNowPlayingMovies getMovies;

    public MoviesPresenter(MoviesContract.View view, GetNowPlayingMovies getMovies) {
        this.view = view;
        this.getMovies = getMovies;
    }

    @Override
    public void getMovies() {
        getMovies.get(new GetNowPlayingMovies.GetMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<SimpleMovie> movies) {
                view.onMoviesLoaded(movies);
            }
        });
    }
}
