package com.youknow.movie.ui.details

import com.youknow.movie.domain.usecase.GetMovie


class DetailsPresenter(
    private val getMovie: GetMovie
) {

    private val TAG = DetailsPresenter::class.java.simpleName

//    override fun getMovie(movieId: String) {
//        disposable.add(
//            getMovie.get(movieId)
//                .doOnSubscribe {
//                    view.showProgressBar(View.VISIBLE)
//                    view.hideError()
//                }
//                .subscribeOn(ioScheduler)
//                .observeOn(uiScheduler)
//                .subscribe({ movie ->
//                    view.showProgressBar(View.GONE)
//                    view.onMovieLoaded(movie)
//                }, { t ->
//                    view.showProgressBar(View.GONE)
//                    view.onError(R.string.err_get_movie_failed)
//                    Log.e(TAG, "[Y.M.] getMovie - failed: ${t.message}", t)
//                })
//        )
//    }
}