package com.kelompok_15.tb_ptb.retrofit;

import com.kelompok_15.tb_ptb.DetailMahasiswaActivity;
import com.kelompok_15.tb_ptb.retrofit.detailmahasiswa.DetailMahasiswaResponse;
import com.kelompok_15.tb_ptb.retrofit.detailtamahasiswa.DetailTAResponse;
import com.kelompok_15.tb_ptb.retrofit.detailtamahasiswa.SupervisorsItem;
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

    @GET("api/theses/277/trials/")
    Call<DetailMahasiswaResponse> detailmahasiswaresponse (
            @Header("Authorization") String token
    );

    //277 detailMahasiswa
    @GET("api/theses/277")
    Call<ThesesItem> theseitems (
            @Header("Authorization") String token
    );

    //309 detailTA
    @GET("api/theses/309")
    Call<DetailTAResponse> detailTaMahasiswaresponse (
            @Header("Authorization") String token
    );

    @GET("api/theses/309")
    Call<SupervisorsItem> supervisors (
            @Header("Authorization") String token
    );
}
