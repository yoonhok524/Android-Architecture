package com.youknow.data.source.cache;

import com.youknow.data.source.MoviesDataSource;
import com.youknow.domain.repository.MoviesRepository;

public class MoviesCacheDataSource implements MoviesDataSource {

    @Override
    public void getNowPlaying(MoviesRepository.MoviesLoadedCallback callback) {

    }

    @Override
    public void getUpcoming(MoviesRepository.MoviesLoadedCallback callback) {

    }

    @Override
    public void getMovie(String movieId, MoviesRepository.MovieLoadedCallback callback) {

    }
}
