package com.example.rebelbob11.moviepractice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URl = "https://api.themoviedb.org/3/";
    public static final String BASE_URL1 = "http://172.17.28.65:8080";

    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){
        if(retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static Retrofit retrofit1 = null;

    public static  Retrofit getRetrofit1(){
        if(retrofit1 == null){

            retrofit1 = new Retrofit.Builder()
                    .baseUrl(BASE_URL1)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit1;
    }


}
