package com.kelompok_15.tb_ptb.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface MainInterface {

    @POST("api/login")
    Call<LoginResponse> postLogin (
            @Field("email") String email,
            @Field("password") String password);
}
