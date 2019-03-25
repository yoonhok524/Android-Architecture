package com.youknow.data.source.remote.api;

import retrofit2.Retrofit;

public class TmdbServiceProvider {

    private TmdbServiceProvider() {

    }

    public static TmdbService getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .build();

        return retrofit.create(TmdbService.class);
    }

}
