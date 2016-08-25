package com.myfirstapp.myfirstapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WikipediaApiManager {

    final Retrofit retrofit;

    public WikipediaApiManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://en.wikipedia.org/api/rest_v1/page/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public WikipediaApi createApiEndpoint() {
        return retrofit.create(WikipediaApi.class);
    }
}
