package com.kelompok_15.tb_ptb.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MainInterface {

    @POST("api/login")
    Call<LoginResponse> postLogin (@Body LoginBody loginBody);
}
