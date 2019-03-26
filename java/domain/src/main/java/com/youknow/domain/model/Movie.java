package com.youknow.domain.model;

import lombok.Data;

@Data
public class Movie {
    private boolean adult;
    private String homepage;
    private int id;
    private String overview;
    private float popularity;
    private String posterPath;
    private String releaseDate;
    private int runtime;
    private String status;
    private String title;
    private float voteAverage;
    private int voteCount;

    public Movie(boolean adult, String homepage, int id, String overview, float popularity, String posterPath, String releaseDate, int runtime, String status, String title, float voteAverage, int voteCount) {
        this.adult = adult;
        this.homepage = homepage;
        this.id = id;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.status = status;
        this.title = title;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }
}
