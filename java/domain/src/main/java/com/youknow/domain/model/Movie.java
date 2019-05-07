package com.youknow.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Movie {
    private boolean adult;
    private List<String> genres;
    private String homepage;
    private int id;
    private String overview;
    private float popularity;
    private String posterPath;
    private String releaseDate;
    private int runtime;
    private String status;
    private String tagline;
    private String title;
    private float voteAverage;
    private int voteCount;
}
