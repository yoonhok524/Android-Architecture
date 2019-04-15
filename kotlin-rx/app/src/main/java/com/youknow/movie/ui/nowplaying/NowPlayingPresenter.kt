package com.youknow.movie.ui.nowplaying

import android.os.Looper
import android.view.View
import com.youknow.domain.usecase.GetNowPlayingMovies
import com.youknow.movie.R
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

class NowPlayingPresenter(
    private val view: NowPlayingContract.View,
    private val getMovies: GetNowPlayingMovies,
    private val ioScheduler: Scheduler = Schedulers.io(),
    private val uiScheduler: Scheduler = AndroidSchedulers.from(Looper.getMainLooper(), true),
    private val disposable: CompositeDisposable = CompositeDisposable()
) : NowPlayingContract.Presenter, AnkoLogger {

    override fun unsubscribe() {
        disposable.clear()
    }

    override fun getMoviesNowPlaying() {
        disposable.add(
            getMovies.get()
                .doOnSubscribe {
                    view.showProgressBar(View.VISIBLE)
                    view.hideError()
                }
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