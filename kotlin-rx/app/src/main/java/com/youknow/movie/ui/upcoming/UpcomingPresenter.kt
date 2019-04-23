package com.youknow.movie.ui.upcoming

import android.view.View
import com.youknow.domain.usecase.GetUpcomingMoviesUsecase
import com.youknow.movie.R
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

class UpcomingPresenter(
    private val view: UpcomingContract.View,
    private val getMovies: GetUpcomingMoviesUsecase,
    private val ioScheduler: Scheduler = Schedulers.io(),
    private val uiScheduler: Scheduler = AndroidSchedulers.mainThread(),
    private val disposable: CompositeDisposable = CompositeDisposable()
) : UpcomingContract.Presenter, AnkoLogger {

    override fun unsubscribe() {
        disposable.clear()
    }

    override fun getUpcomingMovies() {
        view.showProgressBar(View.VISIBLE)
        view.hideError()

        disposable.add(
            getMovies.get()
                .subscribeOn(ioScheduler)
                .observeOn(uiScheduler)
                .subscribe({ movies ->
                    view.showProgressBar(View.GONE)
                    if (movies.isNullOrEmpty()) {
                        view.onError(R.string.err_movies_not_exists)
                    } else {
                        view.onMoviesLoaded(movies)
                    }
                }, {t ->
                    view.showProgressBar(View.GONE)
                    view.onError(R.string.err_get_movies_failed)
                    error("[Y.M.] getMoviesNowPlaying - failed: ${t.message}", t)
                })
        )
    }

}