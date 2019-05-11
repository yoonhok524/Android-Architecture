package com.youknow.movie.ui.nowplaying

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.youknow.data.repository.MoviesRepositoryImpl
import com.youknow.data.source.cache.MoviesCacheDataSource
import com.youknow.data.source.remote.MoviesRemoteDataSource
import com.youknow.data.source.remote.api.MoviesApi
import com.youknow.domain.model.SimpleMovie
import com.youknow.domain.usecase.GetNowPlayingMoviesUsecase
import com.youknow.movie.R
import com.youknow.movie.ui.MOVIE_ID
import com.youknow.movie.ui.adapter.MoviesAdapter
import com.youknow.movie.ui.common.GridItemDecoration
import com.youknow.movie.ui.details.DetailsActivity
import kotlinx.android.synthetic.main.fragment_movies.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class NowPlayingFragment : Fragment(), NowPlayingContract.View, MoviesAdapter.MovieClickListener, AnkoLogger {

    private val presenter: NowPlayingContract.Presenter by lazy {
        val movieCacheDataSource = MoviesCacheDataSource()
        val movieRemoteDataSource = MoviesRemoteDataSource(MoviesApi.getService())
        val movieRepository = MoviesRepositoryImpl(movieCacheDataSource, movieRemoteDataSource)
        val getNowPlayingMoviesUsecase = GetNowPlayingMoviesUsecase(movieRepository)

        NowPlayingPresenter(this, getNowPlayingMoviesUsecase)
    }

    private val moviesAdapter: MoviesAdapter by lazy {
        MoviesAdapter(
            context!!,
            this
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getMoviesNowPlaying()

        rvMovies.adapter = moviesAdapter
        rvMovies.layoutManager = GridLayoutManager(context, resources.getInteger(R.integer.grid_layout_columns))
        rvMovies.addItemDecoration(GridItemDecoration(4))

        info("[Movies] onViewCreated")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
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

    override fun onMovieClick(movieId: String) {
        startActivity(Intent(context, DetailsActivity::class.java).putExtra(MOVIE_ID, movieId))
    }
}
