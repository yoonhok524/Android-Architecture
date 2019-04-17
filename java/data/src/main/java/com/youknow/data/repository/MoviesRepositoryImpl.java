package com.youknow.data.repository;

import com.youknow.data.source.MoviesDataSource;
import com.youknow.domain.repository.MoviesRepository;

public class MoviesRepositoryImpl implements MoviesRepository {

    private MoviesDataSource moviesLocalDataSource;
    private MoviesDataSource moviesRemoteDataSource;

    public MoviesRepositoryImpl(MoviesDataSource localDataSource, MoviesDataSource remoteDataSource) {
        moviesLocalDataSource = localDataSource;
        moviesRemoteDataSource = remoteDataSource;
    }

    @Override
    public void getNowPlaying(MoviesLoadedCallback callback) {
        moviesRemoteDataSource.getNowPlaying(callback);
    }

    @Override
    public void getUpcoming(MoviesLoadedCallback callback) {
        moviesRemoteDataSource.getUpcoming(callback);
    }

    @Override
    public void getMovie(String movieId, MovieLoadedCallback callback) {
        moviesRemoteDataSource.getMovie(movieId, callback);
    }
}
