package com.kelompok_15.tb_ptb.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface MainInterface {

    @POST("login/")
    Call<LoginResponse> login (
            @Field("username")String username,
            @Field("password")String password
    );
}
