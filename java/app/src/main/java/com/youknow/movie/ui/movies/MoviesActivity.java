package com.youknow.movie.ui.movies;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.youknow.data.repository.MoviesRepositoryImpl;
import com.youknow.data.source.cache.MoviesCacheDataSource;
import com.youknow.data.source.remote.MoviesRemoteDataSource;
import com.youknow.data.source.remote.api.TmdbServiceProvider;
import com.youknow.domain.model.SimpleMovie;
import com.youknow.domain.usecase.impl.GetNowPlayingMoviesUsecase;
import com.youknow.movie.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;

public class MoviesActivity extends AppCompatActivity implements MoviesContract.View {

    private MoviesContract.Presenter presenter;
//    private MoviesAdapter moviesAdapter;

//    @BindView(R.id.rvMovies)
//    RecyclerView rvMovies;
    @BindView(R.id.tvErrMessage)
    TextView tvErrMessage;
    @BindView(R.id.moviesProgressBar)
    ProgressBar moiesProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        presenter = new MoviesPresenter(this, new GetNowPlayingMoviesUsecase(new MoviesRepositoryImpl(new MoviesCacheDataSource(), new MoviesRemoteDataSource(TmdbServiceProvider.getService()))));
        presenter.getMovies();

//        moviesAdapter = new MoviesAdapter(this);
//        rvMovies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        rvMovies.setAdapter(moviesAdapter);
    }

    @Override
    public void onMoviesLoaded(List<SimpleMovie> movies) {
//        moviesAdapter.setMovies(movies);
    }

}
