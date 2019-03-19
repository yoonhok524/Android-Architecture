package com.youknow.movie.ui.movies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.youknow.domain.model.Movie;
import com.youknow.movie.R;

import java.util.List;

public class MoviesActivity extends AppCompatActivity implements MoviesContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }

    @Override
    public void onMoviesLoaded(List<Movie> movies) {

    }
}
