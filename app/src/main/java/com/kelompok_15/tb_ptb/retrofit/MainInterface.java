package com.kelompok_15.tb_ptb.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

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

    @GET("api/theses/{id}/logbooks")
    Call<ListLogbook> listlogbook(
            @Path("id") Integer id,
            @Header("Authorization") String token);

    @GET("api/theses/{id}/trials")
    Call<DetailSidangResponse> detailSidangTa(
            @Path("id") Integer thesis_id,
            @Header("Authorization") String token);


}
