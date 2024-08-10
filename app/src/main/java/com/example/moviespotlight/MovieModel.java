package com.example.moviespotlight;

public class MovieModel {

    private String title,overView,poster_path, release_date;
    private Double vote_average;

    public MovieModel(String title, String overView, String poster_Path, String releaseDate, Double vote_average) {
        this.title = title;
        this.overView = overView;
        this.poster_path = poster_Path;
        this. release_date = releaseDate;
        this.vote_average =vote_average;
    }

    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public String getReleaseDate() {
        return  release_date;
    }

    public Double getVote_average() {
        return vote_average;
    }
}
