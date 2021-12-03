package com.example.appdemo.VolleyandRetrofitAPI;

import com.google.gson.annotations.SerializedName;

public class Demo {

    @SerializedName("ServiceId")
    private String serviceId;

    @SerializedName("ServiceName")
    private String serviceName;

    @SerializedName("Amount")
    private int amount;

    @SerializedName("Min_Amount")
    private int minAmount;

    @SerializedName("Category")
    private String category;

    @SerializedName("HVC_Rate")
    private int hVCRate;

    @SerializedName("Old_Rate")
    private int oldRate;

    @SerializedName("NHF_Rate")
    private Object  nHFRate;

    @SerializedName("DSA_Rate")
    private int dSARate;




    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int gethVCRate() {
        return hVCRate;
    }

    public void sethVCRate(int hVCRate) {
        this.hVCRate = hVCRate;
    }

    public int getOldRate() {
        return oldRate;
    }

    public void setOldRate(int oldRate) {
        this.oldRate = oldRate;
    }

    public Object getnHFRate() {
        return nHFRate;
    }

    public void setnHFRate(Object nHFRate) {
        this.nHFRate = nHFRate;
    }

    public int getdSARate() {
        return dSARate;
    }

    public void setdSARate(int dSARate) {
        this.dSARate = dSARate;
    }
}
