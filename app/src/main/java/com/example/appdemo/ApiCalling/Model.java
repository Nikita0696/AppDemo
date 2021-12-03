package com.example.appdemo.ApiCalling;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {

    private String response;
    private String resId;
    @SerializedName("Handbill")
    private List<HandbillDTO> handbill;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public List<HandbillDTO> getHandbill() {
        return handbill;
    }

    public void setHandbill(List<HandbillDTO> handbill) {
        this.handbill = handbill;
    }

    public static class HandbillDTO {
        private String url;
        private String id;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }


}
