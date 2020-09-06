package com.lionelnkeoua.pluralsight1.api;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://gadsapi.herokuapp.com/";
    public static Retrofit retrofit;

    public static Retrofit getApiClient(){

        if (retrofit == null){


            retrofit = new Retrofit .Builder()
                                    .baseUrl(BASE_URL)
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();

        }

        return retrofit;

    }
}
