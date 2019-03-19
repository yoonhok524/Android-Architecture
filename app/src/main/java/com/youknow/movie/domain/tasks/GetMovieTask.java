package com.youknow.movie.domain.tasks;

import android.os.AsyncTask;

import com.youknow.movie.data.api.model.TmdbMovie;
import com.youknow.movie.data.source.MoviesRepository;

public class GetMovieTask extends AsyncTask {

    private MoviesRepository mMoviesRepository;

    public GetMovieTask(MoviesRepository moviesRepository) {
        mMoviesRepository = moviesRepository;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        String movieId = "";
        TmdbMovie tmdbMovie = mMoviesRepository.getMovie(movieId);
        return null;
    }
}
