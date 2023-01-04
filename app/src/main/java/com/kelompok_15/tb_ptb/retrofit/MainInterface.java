package com.kelompok_15.tb_ptb.retrofit;

import com.kelompok_15.tb_ptb.DetailMahasiswaActivity;
import com.kelompok_15.tb_ptb.retrofit.detailMahasiswaReal.DetailMahasiswa1Response;
import com.kelompok_15.tb_ptb.retrofit.detailtaMahasiswareal.DetailTAMahasiswa1Response;
import com.kelompok_15.tb_ptb.retrofit.detialTAmahasiswa.DetailTAResponse;
import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.ListMahasiswaResponse;
import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.ThesesItem;

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

    @GET("api/thesis/advisors")
    Call<ListMahasiswaResponse> listmahasiswaresponse (
            @Header("Authorization") String token
    );


    //309 detailTA
    @GET("api/theses/{id}")
    Call<DetailMahasiswa1Response> detailMahasiswa (
            @Header("Authorization") String token,
            @Path("id") int id
    );

    @GET("api/theses/{id}")
    Call<DetailTAResponse> detailtaresponse (
            @Header("Authorization") String token,
            @Path("id") int id
    );

}
