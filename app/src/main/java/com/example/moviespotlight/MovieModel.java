package com.example.moviespotlight;

public class MovieModel {

    private String title,overView,posterPath,releaseDate;
    private Double rating;

    public MovieModel(String title, String overView, String posterPath, String releaseDate, Double rating) {
        this.title = title;
        this.overView = overView;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Double getRating() {
        return rating;
    }
}
