package com.youknow.movie.ui.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.youknow.movie.R
import com.youknow.movie.databinding.ActivityDetailsBinding
import com.youknow.movie.ui.MOVIE_ID
import com.youknow.movie.ui.adapter.GenreAdapter
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {

    private val TAG = DetailsActivity::class.java.simpleName

    private val viewModel: DetailsViewModel by viewModels()
    private val dataBinding: ActivityDetailsBinding by lazy {
        DataBindingUtil.setContentView<ActivityDetailsBinding>(this, R.layout.activity_details)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (!intent.hasExtra(MOVIE_ID)) {
            Log.e(TAG, "[Y.M.] onCreate - There is no movieId")
            finish()
            return
        }

        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = this
        dataBinding.rvGenres.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        dataBinding.rvGenres.adapter = GenreAdapter()

        val movieId = intent.getStringExtra(MOVIE_ID)
        viewModel.getMovie(movieId)
    }

    fun onError(msgResId: Int) {
        tvErrMessage.visibility = View.VISIBLE
        tvErrMessage.setText(msgResId)
    }

    fun hideError() {
        tvErrMessage.visibility = View.GONE
    }
}