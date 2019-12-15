package com.youknow.movie.ui.upcoming

import com.youknow.movie.domain.usecase.impl.GetUpcomingMoviesUsecase


class UpcomingPresenter(
    private val getMovies: GetUpcomingMoviesUsecase
) {

    private val TAG = UpcomingPresenter::class.java.simpleName

    fun getUpcomingMovies() {
//        view.showProgressBar(View.VISIBLE)
//        view.hideError()
//
//        disposable.add(
//            getMovies.get()
//                .subscribeOn(ioScheduler)
//                .observeOn(uiScheduler)
//                .subscribe({ movies ->
//                    view.showProgressBar(View.GONE)
//                    if (movies.isNullOrEmpty()) {
//                        view.onError(R.string.err_movies_not_exists)
//                    } else {
//                        view.onMoviesLoaded(movies)
//                    }
//                }, {t ->
//                    view.showProgressBar(View.GONE)
//                    view.onError(R.string.err_get_movies_failed)
//                    Log.e(TAG, "[Y.M.] getMoviesNowPlaying - failed: ${t.message}", t)
//                })
//        )
    }

}