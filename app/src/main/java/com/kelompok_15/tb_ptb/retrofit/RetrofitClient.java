package com.kelompok_15.tb_ptb.retrofit;

import androidx.annotation.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public String API_BASE_URL = "";

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.client(httpClient.build()).build();


    /*  @NonNull
    public static ... ...(){
        String API_BASE_URL = "";
    }*/
}
