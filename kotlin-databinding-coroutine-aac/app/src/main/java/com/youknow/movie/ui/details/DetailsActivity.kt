package com.youknow.movie.ui.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.youknow.movie.R
import com.youknow.movie.ui.MOVIE_ID
import com.youknow.movie.ui.adapter.GenreAdapter
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {

    private val TAG = DetailsActivity::class.java.simpleName

    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (!intent.hasExtra(MOVIE_ID)) {
            Log.e(TAG, "[Y.M.] onCreate - There is no movieId")
            finish()
            return
        }

        viewModel.isLoading.observe(this, Observer {
            movieProgressBar.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel.movie.observe(this, Observer { movie ->
            tvOverviewLabel.visibility = View.VISIBLE

            rvGenres.adapter = GenreAdapter(movie.genres)
            rvGenres.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

            Glide.with(this).load("https://image.tmdb.org/t/p/w500/${movie.posterPath}")
                .into(ivPoster)
            tvOverview.text = movie.overview
            tvReleaseDate.text = movie.releaseDate
            tvRuntime.text = getString(R.string.runtime_args, movie.runtime)
            tvVoteAvg.text = movie.voteAverage.toString()
            tvTagline.text = "\"${movie.tagline}\""
        })

        val movieId = intent.getStringExtra(MOVIE_ID)
        viewModel.getMovie(movieId)

    }

    fun showProgressBar(visibility: Int) {
        movieProgressBar.visibility = visibility
    }

    fun onError(msgResId: Int) {
        tvErrMessage.visibility = View.VISIBLE
        tvErrMessage.setText(msgResId)
    }

    fun hideError() {
        tvErrMessage.visibility = View.GONE
    }
}