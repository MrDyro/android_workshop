package com.myfirstapp.myfirstapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WikipediaApi {

    @GET("summary/{query}")
    Call<WikipediaApiModel> fetchSummary(@Path("query") final String query);
}
