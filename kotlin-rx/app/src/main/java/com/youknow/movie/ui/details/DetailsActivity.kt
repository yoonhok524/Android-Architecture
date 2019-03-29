package com.youknow.movie.ui.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import com.youknow.data.source.cache.MoviesCacheDataSource
import com.youknow.data.source.remote.MoviesRemoteDataSource
import com.youknow.data.source.remote.api.MoviesApi
import com.youknow.data.repository.MoviesRepositoryImpl
import com.youknow.domain.model.Movie
import com.youknow.domain.usecase.GetMovieUsecase
import com.youknow.movie.R
import com.youknow.movie.ui.movies.MOVIE_ID
import kotlinx.android.synthetic.main.activity_details.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

class DetailsActivity : AppCompatActivity(), DetailsContract.View, AnkoLogger {

    private val detailsPresenter: DetailsContract.Presenter by lazy {
        val moviesCacheDataSource = MoviesCacheDataSource()
        val moviesRemoteDataSource = MoviesRemoteDataSource(MoviesApi.getService())
        val moviesRepository = MoviesRepositoryImpl(moviesCacheDataSource, moviesRemoteDataSource)
        val getMovieUsecase = GetMovieUsecase(moviesRepository)
        DetailsPresenter(this, getMovieUsecase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (!intent.hasExtra(MOVIE_ID)) {
            error("[Y.M.] onCreate - There is no movieId")
            finish()
            return
        }

        val movieId = intent.getStringExtra(MOVIE_ID)
        detailsPresenter.getMovie(movieId)
    }

    override fun onDestroy() {
        super.onDestroy()
        detailsPresenter.unsubscribe()
    }

    override fun showProgressBar(visibility: Int) {
        movieProgressBar.visibility = visibility
    }

    override fun onMovieLoaded(movie: Movie) {
        title = movie.title
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/${movie.posterPath}").into(ivPoster)
        tvOverview.text = movie.overview
        tvReleaseDate.text = movie.releaseDate
        tvRuntime.text = getString(R.string.runtime_args, movie.runtime)
        tvVoteAvg.text = movie.voteAverage.toString()
    }

    override fun onError(msgResId: Int) {
        tvErrMessage.visibility = View.VISIBLE
        tvErrMessage.setText(msgResId)
    }

    override fun hideError() {
        tvErrMessage.visibility = View.GONE
    }
}