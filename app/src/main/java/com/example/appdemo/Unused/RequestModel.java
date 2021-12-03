package com.example.appdemo.Unused;

import com.google.gson.annotations.SerializedName;

public class RequestModel {

    @SerializedName("ClientCode")
    private String clientCode;

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }
}
