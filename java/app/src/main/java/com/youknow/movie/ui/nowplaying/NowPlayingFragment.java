package com.youknow.movie.ui.nowplaying;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.youknow.data.repository.MoviesRepositoryImpl;
import com.youknow.data.source.cache.MoviesCacheDataSource;
import com.youknow.data.source.remote.MoviesRemoteDataSource;
import com.youknow.data.source.remote.api.TmdbServiceProvider;
import com.youknow.domain.model.SimpleMovie;
import com.youknow.domain.usecase.GetUpcomingMovies;
import com.youknow.domain.usecase.impl.GetUpcomingMoviesUsecase;
import com.youknow.movie.R;
import com.youknow.movie.ui.adapter.MoviesAdapter;
import com.youknow.movie.ui.common.GridItemDecoration;
import com.youknow.movie.ui.details.DetailsActivity;

import java.util.List;

import static com.youknow.movie.ui.MainActivity.MOVIE_ID;

public class NowPlayingFragment extends Fragment implements NowPlayingContract.View, MoviesAdapter.MovieClickListener {

    private NowPlayingContract.Presenter presenter;

    private RecyclerView rvMovies;
    private ProgressBar moviesProgressBar;
    private TextView tvErrMessage;
    private MoviesAdapter moviesAdapter;

    public NowPlayingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        GetUpcomingMovies getUpcomingMovies = new GetUpcomingMoviesUsecase(new MoviesRepositoryImpl(new MoviesCacheDataSource(), new MoviesRemoteDataSource(TmdbServiceProvider.getService())));
        presenter = new NowPlayingPresenter(this, getUpcomingMovies);
        View root = inflater.inflate(R.layout.fragment_movies, container, false);

        rvMovies = root.findViewById(R.id.rvMovies);
        moviesProgressBar = root.findViewById(R.id.moviesProgressBar);
        tvErrMessage = root.findViewById(R.id.tvErrMessage);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moviesAdapter = new MoviesAdapter(getContext(), this);
        rvMovies.setAdapter(moviesAdapter);
        rvMovies.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rvMovies.addItemDecoration(new GridItemDecoration(32));

        presenter.getUpcomingMovies();
    }

    @Override
    public void showProgressBar(int visibility) {
        moviesProgressBar.setVisibility(visibility);
    }

    @Override
    public void onMoviesLoaded(List<SimpleMovie> movies) {
        moviesAdapter.setMovies(movies);
    }

    @Override
    public void onError(int msgResId) {
        tvErrMessage.setVisibility(View.VISIBLE);
        tvErrMessage.setText(msgResId);
    }

    @Override
    public void hideError() {
        tvErrMessage.setVisibility(View.GONE);
    }

    @Override
    public void onMovieClick(String movieId) {
        startActivity(new Intent(getContext(), DetailsActivity.class).putExtra(MOVIE_ID, movieId));
    }
}
