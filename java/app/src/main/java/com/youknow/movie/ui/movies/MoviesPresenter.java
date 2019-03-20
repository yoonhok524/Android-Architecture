package com.youknow.movie.ui.movies;

import com.youknow.movie.domain.tasks.GetMoviesTask;

public class MoviesPresenter implements MoviesContract.Presenter {

    private MoviesContract.View mView;
    private GetMoviesTask mGetMovies;

    public MoviesPresenter(MoviesContract.View view, GetMoviesTask getMoviesTask) {
        mView = view;
        mGetMovies = getMoviesTask;
    }

    @Override
    public void getMovies() {
        mGetMovies.execute();
    }
}
