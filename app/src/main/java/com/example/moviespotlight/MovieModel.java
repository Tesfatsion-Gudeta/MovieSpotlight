package com.example.moviespotlight;

public class MovieModel {

    private String title,overView,poster_path, release_date;
    private int total_pages;
    private Double vote_average;

    public MovieModel(String title, String overView, String poster_path, String release_date, int total_pages, Double vote_average) {
        this.title = title;
        this.overView = overView;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.total_pages = total_pages;
        this.vote_average = vote_average;
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

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
