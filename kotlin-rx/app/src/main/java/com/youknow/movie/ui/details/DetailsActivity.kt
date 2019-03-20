package com.youknow.movie.ui.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.youknow.movie.R

class DetailsActivity: AppCompatActivity(), DetailsContract.View {
    private val detailsPresenter: DetailsContract.Presenter by lazy {
        DetailsPresenter(
            this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }
}