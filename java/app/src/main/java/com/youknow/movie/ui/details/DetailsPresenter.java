package com.youknow.movie.ui.details;

import android.util.Log;

import com.youknow.domain.model.Movie;
import com.youknow.domain.usecase.GetMovie;
import com.youknow.domain.usecase.impl.GetMovieUsecase;

public class DetailsPresenter implements DetailsContract.Presenter {

    private DetailsContract.View view;
    private GetMovieUsecase getMovieUsecase;

    DetailsPresenter(DetailsContract.View view, GetMovieUsecase getMovieUsecase) {
        this.view = view;
        this.getMovieUsecase = getMovieUsecase;
    }

    @Override
    public void getMovie(String movieId) {
        Log.d("Test", "[Movie] getMovie");
        getMovieUsecase.get(movieId, new GetMovie.GetMovieCallback() {
            @Override
            public void onMovieLoaded(Movie movie) {
                view.onMovieLoaded(movie);
            }
        });
    }
}
