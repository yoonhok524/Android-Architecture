package com.youknow.data.source.remote.api;

import retrofit2.Retrofit;

public class TmdbServiceProvider {

    private static TmdbService tmdbService = null;

    private TmdbServiceProvider() {
    }

    public static synchronized TmdbService getService() {
        if (tmdbService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .build();

            tmdbService = retrofit.create(TmdbService.class);
        }

        return tmdbService;
    }

}
