package com.youknow.movie.ui.upcoming;

import android.view.View;

import com.youknow.domain.model.SimpleMovie;
import com.youknow.domain.usecase.GetUpcomingMovies;
import com.youknow.movie.ui.nowplaying.NowPlayingContract.Presenter;

import java.util.List;

public class UpcomingPresenter implements Presenter {

    private UpcomingContract.View view;
    private GetUpcomingMovies getMovies;

    UpcomingPresenter(UpcomingContract.View view, GetUpcomingMovies getMovies) {
        this.view = view;
        this.getMovies = getMovies;
    }

    @Override
    public void getUpcomingMovies() {
        view.showProgressBar(View.VISIBLE);
        view.hideError();

        getMovies.get(new GetUpcomingMovies.GetMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<SimpleMovie> movies) {
                view.showProgressBar(View.GONE);
                view.onMoviesLoaded(movies);
            }
        });
    }
}
