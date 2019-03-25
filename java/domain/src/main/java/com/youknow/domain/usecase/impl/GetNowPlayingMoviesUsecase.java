package com.youknow.domain.usecase.impl;

import com.youknow.domain.repository.MoviesRepository;
import com.youknow.domain.usecase.GetNowPlayingMovie;

public class GetNowPlayingMoviesUsecase implements GetNowPlayingMovie {

    private MoviesRepository mMoviesRepository;

    public GetNowPlayingMoviesUsecase(MoviesRepository moviesRepository) {
        mMoviesRepository = moviesRepository;
    }

}
