package com.youknow.data.source;

import com.youknow.domain.repository.MoviesRepository;

public interface MoviesDataSource {

    void getMovies(MoviesRepository.MoviesLoadedCallback callback);

    void getMovie(String movieId, MoviesRepository.MovieLoadedCallback callback);

}
