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
    ExaminersItem examiners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sidang);

        SharedPreferences sharedPreferences = getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY",MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");

        MainInterface mainInterface = RetrofitClient.getService();
        Call<DetailSidangResponse> call = mainInterface.detailSidangTa(309,"Bearer " + token);
        call.enqueue((new Callback<DetailSidangResponse>() {
            @Override
            public void onResponse(Call<DetailSidangResponse> call, Response<DetailSidangResponse> response) {
                Log.e("Success", response.toString());
                
                DetailSidangResponse detailSidangResponse = response.body();

//                List<ExaminersItem>  = detailSidangResponse.getExaminers();

                    //String pembimbing1TASidang = ; fileReportSidang
                    //String NIPpembimbing1TASidang = detailSidangResponse.getExaminers().getNIP();
                String tanggalSidang = detailSidangResponse.getTrialAt();
                String jamMulaiSidang = detailSidangResponse.getStartAt();
                String jamSelesaiSidang = detailSidangResponse.getEndAt();
                String fileSlideSidang = detailSidangResponse.getFileSlide();
                String fileJurnalSidang = detailSidangResponse.getFileJournal();
//              Object lokasiSidang = detailSidangResponse.getRoomId();
                String nilaiSidang = detailSidangResponse.getGrade();
                //String judulTASidang = detailSidangResponse.getThesisId();


                TextView pembimbing1TASidangData = findViewById(R.id.pembimbing1TASidang);
                TextView tanggalSidangData = findViewById(R.id.tanggalSidang);
                TextView jamMulaiSidangData = findViewById(R.id.jamMulaiSidang);
                TextView jamSelesaiSidangData = findViewById(R.id.jamSelesaiSidang);
//                TextView lokasiSidangData = findViewById(R.id.lokasiSidang);
                TextView nilaiSidangData = findViewById(R.id.nilaiSidang);
                TextView fileSlideSidangData = findViewById(R.id.fileSlideSidang);
                TextView fileJurnalSidangData = findViewById(R.id.fileJurnalSidang);
               // TextView judulTASidangData = findViewById(R.id.judulTASidang);

               // pembimbing1TASidangData.setText(pembimbing1TASidang);
                tanggalSidangData.setText(tanggalSidang);
                jamMulaiSidangData.setText(jamMulaiSidang);
                jamSelesaiSidangData.setText(jamSelesaiSidang);
//                lokasiSidangData.set(lokasiSidang);
                nilaiSidangData.setText(nilaiSidang);
                fileSlideSidangData.setText(fileSlideSidang);
                fileJurnalSidangData.setText(fileJurnalSidang);
               // judulTASidangData.setText(judulTASidang);


            }

            @Override
            public void onFailure(Call<DetailSidangResponse> call, Throwable t) {
            Log.e("failure", t.getLocalizedMessage());
            }
        }));
        
        

       



    }
}