package com.example.appdemo.GetAPIRetrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetRetrofitClient {

    public static Retrofit retrofit;
    public static final String BASE_URL = "http://scanso.nueclear.com/api/MasterData/GetServiceMaster/";

    public static Retrofit getRetrofitInstanceClient()
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        /*OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request request1 = request.newBuilder()
                        .header("Authorization","Bearer 8nvcC8jRJ3qNcy1-gRRSzfxZG0XkOkIZUphrkx7H46-ZPCwce4rHLBIHFUREB55oIoISAaBSWkgO61fKdSr9AOL4VbzQ5OrXRPF2CAUpO0Zy-TA4i80ohGwrvLW6GFjIjAthrAZrDw_JOE6KGNiOMSdCR4lAsU3wTDfHCIExXZbyQCGXAnOy0GMPJtHgq1BN3aMCgamSNWxp61JF-fEQ7THIkDHbczlLD-JWii9iKrYkTMf1mpTdwDDsxdSfD1GUeOxExE83jln9gsL3P1yeN6_flq-jiz14Z9jSsFIgPGfkvv4U-GGb7flpl6YSfPEVsfErcraE4faU8m1OHRazucutLHzPB3W1T_6cj8N86bY1fK437aCkNh_s8Ei6d2B9rh1En_F8fk3Fq_g-kADxOzKdZLNOws6tzscjwsTLD32d8NYsIWnkB1uD0x6PWKuNKSRfenTHM1WQh4shwJO9beBy63yVGcoCPFi2z-xEzf-ze7p4UyUjBaI3g9TrU7Bx")
                        .method(request.method(),request.body())
                        .build();

                return chain.proceed(request1);
            }
        }).build();*/

        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
