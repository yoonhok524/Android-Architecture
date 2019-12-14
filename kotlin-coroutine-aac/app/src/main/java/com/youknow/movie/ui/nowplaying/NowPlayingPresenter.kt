package com.youknow.movie.ui.nowplaying

import android.os.Looper
import android.util.Log
import android.view.View
import com.youknow.movie.domain.usecase.GetNowPlayingMovies
import com.youknow.movie.R
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NowPlayingPresenter(
    private val view: NowPlayingContract.View,
    private val getMovies: GetNowPlayingMovies,
    private val ioScheduler: Scheduler = Schedulers.io(),
    private val uiScheduler: Scheduler = AndroidSchedulers.from(Looper.getMainLooper(), true),
    private val disposable: CompositeDisposable = CompositeDisposable()
) : NowPlayingContract.Presenter {

    private val TAG = NowPlayingPresenter::class.java.simpleName

    override fun unsubscribe() {
        disposable.clear()
    }

    override fun getMoviesNowPlaying() {
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
                    Log.e(TAG, "[Y.M.] getMoviesNowPlaying - failed: ${t.message}", t)
                })
        )
    }

}