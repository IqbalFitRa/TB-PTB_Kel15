package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.kelompok_15.tb_ptb.retrofit.DetailSidangResponse;
import com.kelompok_15.tb_ptb.retrofit.ExaminersItem;
import com.kelompok_15.tb_ptb.retrofit.ListLogbook;
import com.kelompok_15.tb_ptb.retrofit.LogbooksItem;
import com.kelompok_15.tb_ptb.retrofit.MainInterface;
import com.kelompok_15.tb_ptb.retrofit.Pivot;
import com.kelompok_15.tb_ptb.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSidangActivity extends AppCompatActivity {
    TextView pembimbing1TASidang,NIPpembimbing1TASidang,pembimbing2TASidang,NIPpembimbing2TASidang, tanggalSidang, jamMulaiSidang, jamSelesaiSidang,lokasiSidang,nilaiSidang;
    ExaminersItem examiners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sidang);

        SharedPreferences sharedPreferences = getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY",MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");

        pembimbing1TASidang = findViewById(R.id.pembimbing1TASidang);
        NIPpembimbing1TASidang = findViewById(R.id.NIPpembimbing1TASidang);
        pembimbing2TASidang = findViewById(R.id.pembimbing2TASidang);
        NIPpembimbing2TASidang = findViewById(R.id.NIPpembimbing2TASidang);
        tanggalSidang = findViewById(R.id.tanggalSidang);
        jamMulaiSidang = findViewById(R.id.jamMulaiSidang);
        jamSelesaiSidang = findViewById(R.id.jamSelesaiSidang);
        lokasiSidang = findViewById(R.id.lokasiSidang);
        nilaiSidang = findViewById(R.id.nilaiSidang);

        //minta data ke server
        MainInterface mainInterface = RetrofitClient.getService();
        Call<DetailSidangResponse> call = mainInterface.detailSidangTa(309, "Bearer " + token);
        call.enqueue(new Callback<DetailSidangResponse>() {
            @Override
            public void onResponse(Call<DetailSidangResponse> call, Response<DetailSidangResponse> response) {
                DetailSidangResponse detailSidangResponse = response.body();

                Intent detailSidangTa = getIntent();
                if (detailSidangTa.getExtras() != null) {
                    examiners = (ExaminersItem) detailSidangTa.getSerializableExtra("data");
                    String pembimbing1TASidangData = examiners.getName();
                    String  pembimbing2TASidangData = examiners.getName();
                    String NIPpembimbing1TASidangData = examiners.getNip();
                    String NIPpembimbing2TASidangData = examiners.getNip();

                    pembimbing1TASidang.setText(pembimbing1TASidangData);
                    pembimbing2TASidang.setText(pembimbing2TASidangData);
                    NIPpembimbing1TASidang.setText(NIPpembimbing1TASidangData);
                    NIPpembimbing2TASidang.setText(NIPpembimbing2TASidangData);
                }
                if(detailSidangResponse != null){
                    List<ExaminersItem> examiners = detailSidangResponse.getExaminers();
                }


            }

            @Override
            public void onFailure(Call<DetailSidangResponse> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });


    }
}