package com.youknow.domain.usecase.impl;

import com.youknow.domain.repository.MoviesRepository;
import com.youknow.domain.usecase.GetMovie;

public class GetMovieUsecase implements GetMovie {

    private MoviesRepository mMoviesRepository;

    public GetMovieUsecase(MoviesRepository moviesRepository) {
        mMoviesRepository = moviesRepository;
    }

}
