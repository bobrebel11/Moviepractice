package com.example.rebelbob11.moviepractice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie/popular")
    Call<MovieResponse> getPopularMovieList(@Query("api_key") String apikey);

    @GET("marvel.json")
    Call<List<Hero>> getHeros();
}
