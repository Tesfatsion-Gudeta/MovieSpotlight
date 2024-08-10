package com.example.moviespotlight;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieInterface {

    @GET("movie/now_playing")
    Call<MovieResponse> getMovies(
            @Query("api_key")
            String apiKey,
            @Query("language")
            String language

    );


}
