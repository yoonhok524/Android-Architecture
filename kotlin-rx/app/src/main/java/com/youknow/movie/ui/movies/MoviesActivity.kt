package com.youknow.movie.ui.movies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.youknow.data.datasource.cache.MoviesCacheDataSource
import com.youknow.data.datasource.remote.MoviesRemoteDataSource
import com.youknow.data.datasource.remote.api.MoviesApi
import com.youknow.data.repository.MoviesRepositoryImpl
import com.youknow.domain.model.SimpleMovie
import com.youknow.movie.R
import kotlinx.android.synthetic.main.activity_movies.*
import android.support.v7.widget.LinearSnapHelper
import com.youknow.domain.usecase.GetNowPlayingMoviesUsecase


class MoviesActivity : AppCompatActivity(), MoviesContract.View {

    private val moviesPresenter: MoviesContract.Presenter by lazy {
        val movieCacheDataSource = MoviesCacheDataSource()
        val movieRemoteDataSource = MoviesRemoteDataSource(MoviesApi.getService())
        val movieRepository = MoviesRepositoryImpl(movieCacheDataSource, movieRemoteDataSource)
        val getNowPlayingMoviesUsecase = GetNowPlayingMoviesUsecase(movieRepository)

        MoviesPresenter(this, getNowPlayingMoviesUsecase)
    }

    private val moviesAdapter: MoviesAdapter by lazy { MoviesAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        moviesPresenter.getMoviesNowPlaying()

        LinearSnapHelper().attachToRecyclerView(rvMovies)
        rvMovies.adapter = moviesAdapter
        rvMovies.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        moviesPresenter.unsubscribe()
    }

    override fun showProgressBar(visibility: Int) {
        moviesProgressBar.visibility = visibility
    }

    override fun onMoviesLoaded(movies: List<SimpleMovie>) {
        moviesAdapter.movies.clear()
        moviesAdapter.movies.addAll(movies)
        moviesAdapter.notifyDataSetChanged()
    }

    override fun onError(msgResId: Int) {
        tvErrMessage.visibility = View.VISIBLE
        tvErrMessage.setText(msgResId)
    }

    override fun hideError() {
        tvErrMessage.visibility = View.GONE
    }
}
