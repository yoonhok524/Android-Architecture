package com.youknow.domain.model;

import lombok.Data;

@Data
public class SimpleMovie {
    private String posterPath;
    private boolean adult;
    private String releaseDate;
    private int id;
    private String title;
    private float voteAverage;

    public SimpleMovie(String posterPath, boolean adult, String releaseDate, int id, String title, float voteAverage) {
        this.posterPath = posterPath;
        this.adult = adult;
        this.releaseDate = releaseDate;
        this.id = id;
        this.title = title;
        this.voteAverage = voteAverage;
    }
}
