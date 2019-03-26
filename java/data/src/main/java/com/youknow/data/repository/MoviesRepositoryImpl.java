package com.youknow.data.repository;

import com.youknow.data.source.MoviesDataSource;
import com.youknow.domain.model.Movie;
import com.youknow.domain.model.SimpleMovie;
import com.youknow.domain.repository.MoviesRepository;

import java.util.List;

public class MoviesRepositoryImpl implements MoviesRepository {

    private MoviesDataSource moviesLocalDataSource;
    private MoviesDataSource moviesRemoteDataSource;

    @Override
    public void getMovies(MoviesLoadedCallback callback) {
        moviesRemoteDataSource.getMovies(callback);
    }

    @Override
    public void getMovie(String movieId, MovieLoadedCallback callback) {
        moviesRemoteDataSource.getMovie(movieId, callback);
    }
}
