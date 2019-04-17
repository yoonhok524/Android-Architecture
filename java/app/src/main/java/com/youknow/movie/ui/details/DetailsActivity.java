package com.youknow.movie.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youknow.data.repository.MoviesRepositoryImpl;
import com.youknow.data.source.cache.MoviesCacheDataSource;
import com.youknow.data.source.remote.MoviesRemoteDataSource;
import com.youknow.data.source.remote.api.TmdbServiceProvider;
import com.youknow.domain.model.Movie;
import com.youknow.domain.usecase.impl.GetMovieUsecase;
import com.youknow.movie.R;
import com.youknow.movie.ui.adapter.GenreAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.youknow.movie.ui.MainActivity.MOVIE_ID;

public class DetailsActivity extends AppCompatActivity implements DetailsContract.View {

    private DetailsContract.Presenter detailsPresenter;

    private ProgressBar movieProgressBar;
    private TextView tvOverviewLabel;
    private TextView tvOverview;
    private TextView tvReleaseDate;
    private TextView tvRuntime;
    private TextView tvVoteAvg;
    private TextView tvTagline;
    private TextView tvErrMessage;
    private ImageView ivPoster;
    private RecyclerView rvGenres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        movieProgressBar = findViewById(R.id.movieProgressBar);
        tvOverviewLabel = findViewById(R.id.tvOverviewLabel);
        tvOverview = findViewById(R.id.tvOverview);
        tvReleaseDate = findViewById(R.id.tvReleaseDate);
        tvRuntime = findViewById(R.id.tvRuntime);
        tvVoteAvg = findViewById(R.id.tvVoteAvg);
        tvTagline = findViewById(R.id.tvTagline);
        tvErrMessage = findViewById(R.id.tvErrMessage);
        ivPoster = findViewById(R.id.ivPoster);
        rvGenres = findViewById(R.id.rvGenres);

        Intent intent = getIntent();
        if (!intent.hasExtra(MOVIE_ID)) {
            Log.e("Test", "[Movie] MOVIE_ID is null");
            finish();
            return;
        }

        String movieId = intent.getStringExtra(MOVIE_ID);
        Log.d("Test", "[Movie] MOVIE_ID: " + movieId);

        GetMovieUsecase getMovieUsecase = new GetMovieUsecase(new MoviesRepositoryImpl(new MoviesCacheDataSource(), new MoviesRemoteDataSource(TmdbServiceProvider.getService())));
        detailsPresenter = new DetailsPresenter(this, getMovieUsecase);
        detailsPresenter.getMovie(movieId);
    }

    @Override
    public void showProgressBar(int visibility) {
        movieProgressBar.setVisibility(visibility);
    }

    @Override
    public void onMovieLoaded(Movie movie) {
        Log.d("Test", "[Movie] onMovieLoaded - movie: " + movie);
        tvOverviewLabel.setVisibility(View.VISIBLE);

        rvGenres.setAdapter(new GenreAdapter(movie.getGenres()));
        rvGenres.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false));

        Glide.with(this).load("https://image.tmdb.org/t/p/w500/" + movie.getPosterPath()).into(ivPoster);
        tvOverview.setText(movie.getOverview());
        tvReleaseDate.setText(movie.getReleaseDate());
        tvRuntime.setText(getString(R.string.runtime_args, movie.getRuntime()));
        tvVoteAvg.setText(String.valueOf(movie.getVoteAverage()));
        tvTagline.setText("\"${movie.tagline}\"");
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
}
