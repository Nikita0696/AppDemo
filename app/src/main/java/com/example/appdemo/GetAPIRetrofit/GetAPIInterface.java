package com.example.appdemo.GetAPIRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface GetAPIInterface {
    String auth = "Bearer 8nvcC8jRJ3qNcy1-gRRSzfxZG0XkOkIZUphrkx7H46-ZPCwce4rHLBIHFUREB55oIoISAaBSWkgO61fKdSr9AOL4VbzQ5OrXRPF2CAUpO0Zy-TA4i80ohGwrvLW6GFjIjAthrAZrDw_JOE6KGNiOMSdCR4lAsU3wTDfHCIExXZbyQCGXAnOy0GMPJtHgq1BN3aMCgamSNWxp61JF-fEQ7THIkDHbczlLD-JWii9iKrYkTMf1mpTdwDDsxdSfD1GUeOxExE83jln9gsL3P1yeN6_flq-jiz14Z9jSsFIgPGfkvv4U-GGb7flpl6YSfPEVsfErcraE4faU8m1OHRazucutLHzPB3W1T_6cj8N86bY1fK437aCkNh_s8Ei6d2B9rh1En_F8fk3Fq_g-kADxOzKdZLNOws6tzscjwsTLD32d8NYsIWnkB1uD0x6PWKuNKSRfenTHM1WQh4shwJO9beBy63yVGcoCPFi2z-xEzf-ze7p4UyUjBaI3g9TrU7Bx";

    @GET("CN00000001/7738943013")
    Call<List<DemoPojo>> getAllData(@Header("Authorization") String auth);
}
