package com.example.appdemo.GetAPIRetrofit;

import com.google.gson.annotations.SerializedName;

public class DemoPojo {

    @SerializedName("ServiceName")
    private String serviceName;

    public DemoPojo(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
