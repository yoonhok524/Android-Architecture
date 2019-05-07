package com.youknow.movie.ui.details;

import com.youknow.domain.model.Movie;

public interface DetailsContract {
    interface View {
        void showProgressBar(int visibility);
        void onMovieLoaded(Movie movie);
        void onError(int msgResId);
        void hideError();
    }

    interface Presenter {
        void getMovie(String movieId);
    }
}
