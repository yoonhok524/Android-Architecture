package com.youknow.movie.ui.upcoming

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.youknow.movie.data.repository.MoviesRepositoryImpl
import com.youknow.movie.data.source.cache.MoviesCacheDataSource
import com.youknow.movie.data.source.remote.MoviesRemoteDataSource
import com.youknow.movie.data.source.remote.api.MoviesApi
import com.youknow.movie.domain.model.SimpleMovie
import com.youknow.movie.domain.usecase.impl.GetUpcomingMoviesUsecase
import com.youknow.movie.R
import com.youknow.movie.ui.MOVIE_ID
import com.youknow.movie.ui.adapter.MoviesAdapter
import com.youknow.movie.ui.common.GridItemDecoration
import com.youknow.movie.ui.details.DetailsActivity
import kotlinx.android.synthetic.main.fragment_movies.*


class UpcomingFragment : Fragment(), MoviesAdapter.MovieClickListener {

    private val viewModel: UpcomingViewModel by viewModels()

    private val moviesAdapter: MoviesAdapter by lazy {
        MoviesAdapter(context!!, this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvMovies.adapter = moviesAdapter
        rvMovies.layoutManager = GridLayoutManager(context, resources.getInteger(R.integer.grid_layout_columns))
        rvMovies.addItemDecoration(GridItemDecoration(4))

        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            moviesProgressBar.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            moviesAdapter.movies.clear()
            moviesAdapter.movies.addAll(it)
            moviesAdapter.notifyDataSetChanged()
        })
    }

    override fun onMovieClick(movieId: String) {
        startActivity(Intent(context, DetailsActivity::class.java).putExtra(MOVIE_ID, movieId))
    }

    fun hideError() {
        tvErrMessage.visibility = View.GONE
    }

    fun onError(msgResId: Int) {
        tvErrMessage.visibility = View.VISIBLE
        tvErrMessage.setText(msgResId)
    }
}