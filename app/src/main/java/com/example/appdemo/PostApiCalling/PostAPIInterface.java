package com.example.appdemo.PostApiCalling;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostAPIInterface
{
    @POST("Complaint_module/DH_SUBMIT_LID")
    Call<ResponseDataModel> getAllResponse(@Body RequestDataModel requestDataModel);
}
