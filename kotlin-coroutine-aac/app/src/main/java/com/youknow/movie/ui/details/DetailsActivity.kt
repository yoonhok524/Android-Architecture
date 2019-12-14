package com.youknow.movie.ui.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.youknow.movie.data.repository.MoviesRepositoryImpl
import com.youknow.movie.data.source.cache.MoviesCacheDataSource
import com.youknow.movie.data.source.remote.MoviesRemoteDataSource
import com.youknow.movie.data.source.remote.api.MoviesApi
import com.youknow.movie.domain.model.Movie
import com.youknow.movie.domain.usecase.GetMovieUsecase
import com.youknow.movie.R
import com.youknow.movie.ui.MOVIE_ID
import com.youknow.movie.ui.adapter.GenreAdapter
import kotlinx.android.synthetic.main.activity_details.*



class DetailsActivity : AppCompatActivity(), DetailsContract.View {

    private val TAG = DetailsActivity::class.java.simpleName

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
            Log.e(TAG, "[Y.M.] onCreate - There is no movieId")
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
        tvOverviewLabel.visibility = View.VISIBLE

        rvGenres.adapter = GenreAdapter(movie.genres)
        rvGenres.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        Glide.with(this).load("https://image.tmdb.org/t/p/w500/${movie.posterPath}").into(ivPoster)
        tvOverview.text = movie.overview
        tvReleaseDate.text = movie.releaseDate
        tvRuntime.text = getString(R.string.runtime_args, movie.runtime)
        tvVoteAvg.text = movie.voteAverage.toString()
        tvTagline.text = "\"${movie.tagline}\""
    }

    override fun onError(msgResId: Int) {
        tvErrMessage.visibility = View.VISIBLE
        tvErrMessage.setText(msgResId)
    }

    override fun hideError() {
        tvErrMessage.visibility = View.GONE
    }
}