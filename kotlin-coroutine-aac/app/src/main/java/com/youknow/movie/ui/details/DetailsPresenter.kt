package com.youknow.movie.ui.details

import android.os.Looper
import android.util.Log
import android.view.View
import com.youknow.movie.domain.usecase.GetMovie
import com.youknow.movie.R
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers



class DetailsPresenter(
    private val view: DetailsContract.View,
    private val getMovie: GetMovie,
    private val ioScheduler: Scheduler = Schedulers.io(),
    private val uiScheduler: Scheduler = AndroidSchedulers.from(Looper.getMainLooper(), true),
    private val disposable: CompositeDisposable = CompositeDisposable()
): DetailsContract.Presenter {

    private val TAG = DetailsPresenter::class.java.simpleName

    override fun unsubscribe() {
        disposable.clear()
    }

    override fun getMovie(movieId: String) {
        disposable.add(
            getMovie.get(movieId)
                .doOnSubscribe {
                    view.showProgressBar(View.VISIBLE)
                    view.hideError()
                }
                .subscribeOn(ioScheduler)
                .observeOn(uiScheduler)
                .subscribe({ movie ->
                    view.showProgressBar(View.GONE)
                    view.onMovieLoaded(movie)
                }, { t ->
                    view.showProgressBar(View.GONE)
                    view.onError(R.string.err_get_movie_failed)
                    Log.e(TAG, "[Y.M.] getMovie - failed: ${t.message}", t)
                })
        )
    }
}