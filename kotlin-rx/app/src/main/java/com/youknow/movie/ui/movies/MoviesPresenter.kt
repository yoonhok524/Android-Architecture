package com.youknow.movie.ui.movies

import android.os.Looper
import android.view.View
import com.youknow.domain.usecase.GetNowPlayingMoviesUsecase
import com.youknow.movie.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

class MoviesPresenter(
    private val view: MoviesContract.View,
    private val getMovies: GetNowPlayingMoviesUsecase,
    private val disposable: CompositeDisposable = CompositeDisposable()
) : MoviesContract.Presenter, AnkoLogger {

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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.from(Looper.getMainLooper(), true))
                .subscribe({ movies ->
                    view.showProgressBar(View.GONE)
                    if (movies.isNullOrEmpty()) {
                        view.onError(R.string.err_movies_not_exists)
                    } else {
                        view.onMoviesLoaded(movies)
                    }
                }, {t ->
                    view.showProgressBar(View.GONE)
                    error("[Y.M.] getMoviesNowPlaying - failed: ${t.message}", t)
                    view.onError(R.string.err_get_movies_failed)
                })
        )
    }

}