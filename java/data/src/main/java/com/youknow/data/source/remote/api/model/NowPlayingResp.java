package com.youknow.data.source.remote.api.model;

import com.google.gson.annotations.SerializedName;

import com.youknow.domain.model.SimpleMovie;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NowPlayingResp {
    private int page;
    private List<Result> results;
    private Dates dates;
    private int totalPages;
    private int totalResults;

    public static List<SimpleMovie> mapToDomain(NowPlayingResp nowPlayingResp) {
        System.out.println("[Y.M.] mapToDomain - " + nowPlayingResp);
        List<SimpleMovie> simpleMovieList = new ArrayList<>();
        for (Result result : nowPlayingResp.results) {
            simpleMovieList.add(new SimpleMovie(result.getPosterPath(), result.isAdult(), result.getReleaseDate(), result.getId(), result.getTitle(), result.getVoteAverage()));
        }

        return simpleMovieList;
    }
}

@Data
@NoArgsConstructor
class Result {
    @SerializedName("poster_path")
    private String posterPath;
    private boolean adult;
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("genre_ids")
    private List<Integer> genreIds;
    private int id;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("original_language")
    private String originalLanguage;
    private String title;
    @SerializedName("backdrop_path")
    private String backdropPath;
    private float popularity;
    @SerializedName("vote_count")
    private int voteCount;
    private boolean video;
    @SerializedName("vote_average")
    private float voteAverage;
}

@Data
@NoArgsConstructor
class Dates {
    private String maximum;
    private String minimum;
}
