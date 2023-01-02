package com.kelompok_15.tb_ptb.retrofit;

import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.ListMahasiswaResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MainInterface {

    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> login (
            @Field("username")String username,
            @Field("password")String password
    );

    @POST("api/logout")
    Call<LogoutResponse> logout (
            @Header("Authorization") String token
    );

    @GET("api/thesis/advisors")
    Call<ListMahasiswaResponse> listmahasiswaresponse (

    );

}
