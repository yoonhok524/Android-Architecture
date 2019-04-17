package com.youknow.data.source.remote.api;

import com.youknow.data.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TmdbServiceProvider {

    private static TmdbService tmdbService = null;

    private TmdbServiceProvider() {
    }

    public static synchronized TmdbService getService() {
        if (tmdbService == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (BuildConfig.BUILD_TYPE == "debug") {
                builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
            }
            OkHttpClient client = builder.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl("https://api.themoviedb.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            tmdbService = retrofit.create(TmdbService.class);
        }

        return tmdbService;
    }

}
