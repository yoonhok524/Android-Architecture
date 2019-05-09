package com.youknow.movie

import android.app.Application
import com.youknow.data.repository.MoviesRepositoryImpl
import com.youknow.data.source.MoviesDataSource
import com.youknow.data.source.cache.MoviesCacheDataSource
import com.youknow.data.source.remote.MoviesRemoteDataSource
import com.youknow.data.source.remote.api.MoviesApi
import com.youknow.domain.repository.MoviesRepository
import com.youknow.domain.usecase.GetUpcomingMoviesUsecase
import com.youknow.movie.ui.upcoming.UpcomingContract
import com.youknow.movie.ui.upcoming.UpcomingPresenter
import org.jetbrains.anko.AnkoLogger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

val appModule = module {
    single<MoviesDataSource>(StringQualifier("cache")) { MoviesCacheDataSource() }
    single<MoviesDataSource>(StringQualifier("remote")) { MoviesRemoteDataSource(MoviesApi.getService()) }
    single<MoviesRepository> { MoviesRepositoryImpl(get(StringQualifier("cache")), get(StringQualifier("remote"))) }
    factory<UpcomingContract.Presenter> { UpcomingPresenter(GetUpcomingMoviesUsecase(get())) }
}

class MainApplication : Application(), AnkoLogger {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModule)
        }
    }
}