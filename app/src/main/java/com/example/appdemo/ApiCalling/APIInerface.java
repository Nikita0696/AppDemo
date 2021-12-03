package com.example.appdemo.ApiCalling;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInerface {

    @GET("api/Persuasion/Gethandbills")
    Call<Model> getAllData();
}
