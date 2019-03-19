package com.youknow.movie.domain.tasks;

import android.os.AsyncTask;

import com.youknow.movie.data.api.model.TmdbMovie;
import com.youknow.movie.data.source.MoviesRepository;

import java.util.List;

public class GetMoviesTask extends AsyncTask {

    private MoviesRepository mMoviesRepository;

    public GetMoviesTask(MoviesRepository moviesRepository) {
        mMoviesRepository = moviesRepository;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        List<TmdbMovie> tmdbMovies = mMoviesRepository.getMovies();

        return null;
    }
}
