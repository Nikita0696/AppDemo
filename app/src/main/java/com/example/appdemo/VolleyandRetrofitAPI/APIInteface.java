package com.example.appdemo.VolleyandRetrofitAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIInteface {

    @POST("Login/RegisteredUser")
    Call<UserModel> getData(@Body UserRequestData userRequestData);

    @GET("CN00000001/7738943013")
    Call<List<Demo>> getDataCall(@Header("Authoeization") String token);
}
