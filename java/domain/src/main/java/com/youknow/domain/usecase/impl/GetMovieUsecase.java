package com.youknow.domain.usecase.impl;

import com.youknow.domain.model.Movie;
import com.youknow.domain.repository.MoviesRepository;
import com.youknow.domain.usecase.GetMovie;

public class GetMovieUsecase implements GetMovie {

    private MoviesRepository mMoviesRepository;

    public GetMovieUsecase(MoviesRepository moviesRepository) {
        mMoviesRepository = moviesRepository;
    }

    @Override
    public void get(String movieId, final GetMovieCallback callback) {
        mMoviesRepository.getMovie(movieId, new MoviesRepository.MovieLoadedCallback() {
            @Override
            public void onMovieLoaded(Movie movie) {
                callback.onMovieLoaded(movie);
            }
        });
    }
}
