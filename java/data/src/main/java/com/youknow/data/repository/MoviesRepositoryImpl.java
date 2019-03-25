package com.youknow.data.repository;

import com.youknow.domain.model.Movie;
import com.youknow.domain.model.SimpleMovie;
import com.youknow.domain.repository.MoviesRepository;

import java.util.List;

public class MoviesRepositoryImpl implements MoviesRepository {
    @Override
    public List<SimpleMovie> getMovies() {
        return null;
    }

    @Override
    public Movie getMovie(String movieId) {
        return null;
    }
}
