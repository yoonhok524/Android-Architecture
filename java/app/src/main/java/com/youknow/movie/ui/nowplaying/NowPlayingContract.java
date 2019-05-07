package com.youknow.movie.ui.nowplaying;

import com.youknow.domain.model.SimpleMovie;

import java.util.List;

public interface NowPlayingContract {
    interface View {
        void showProgressBar(int visibility);
        void onMoviesLoaded(List<SimpleMovie> movies);
        void onError(int msgResId);
        void hideError();
    }

    interface Presenter {
        void getUpcomingMovies();
    }
}
