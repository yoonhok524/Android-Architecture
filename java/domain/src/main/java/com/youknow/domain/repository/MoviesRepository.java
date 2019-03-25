package com.youknow.domain.repository;

import com.youknow.domain.model.Movie;
import com.youknow.domain.model.SimpleMovie;

import java.util.List;

public interface MoviesRepository {

    List<SimpleMovie> getMovies();

    Movie getMovie(String movieId);

}
