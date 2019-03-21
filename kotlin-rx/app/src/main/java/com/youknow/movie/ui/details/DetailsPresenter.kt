package com.youknow.movie.ui.details

import android.os.Looper
import android.view.View
import com.youknow.domain.usecase.GetMovie
import com.youknow.domain.usecase.GetMovieUsecase
import com.youknow.movie.R
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

class DetailsPresenter(
    private val view: DetailsContract.View,
    private val getMovie: GetMovie,
    private val ioScheduler: Scheduler = Schedulers.io(),
    private val uiScheduler: Scheduler = AndroidSchedulers.from(Looper.getMainLooper(), true),
    private val disposable: CompositeDisposable = CompositeDisposable()
): DetailsContract.Presenter, AnkoLogger {

    override fun unsubscribe() {
        disposable.clear()
    }

    override fun getMovie(movieId: String) {
        disposable.add(
            getMovie.get(movieId)
                .doOnSubscribe {
                    view.hideError()
                    view.showProgressBar(View.VISIBLE)
                }
                .subscribeOn(ioScheduler)
                .observeOn(uiScheduler)
                .subscribe({ movie ->
                    view.showProgressBar(View.GONE)
                    view.onMovieLoaded(movie)
                }, { t ->
                    view.showProgressBar(View.GONE)
                    view.onError(R.string.err_get_movies_failed)
                    error("[Y.M.] getMovie - failed: ${t.message}", t)
                })
        )
    }
}