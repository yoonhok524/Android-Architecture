package com.youknow.movie.ui.upcoming;

import com.youknow.domain.model.SimpleMovie;

import java.util.List;

public interface UpcomingContract {
    interface View {
        void showProgressBar(int visibility);
        void onMoviesLoaded(List<SimpleMovie> movies);
        void onError(int msgResId);
        void hideError();
    }

    interface Presenter {
        void getMoviesNowPlaying();
    }
}
