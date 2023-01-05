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
import java.util.ArrayList;

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


        int [] listexaminers= {R.id.penguji1TASidang, R.id.penguji2TASidang};
        List<String> list = new ArrayList<>();

        MainInterface mainInterface = RetrofitClient.getService();
        Call<DetailSidangResponse> call = mainInterface.detailSidangTa(277,"Bearer " + token);
        call.enqueue((new Callback<DetailSidangResponse>() {
            @Override
            public void onResponse(Call<DetailSidangResponse> call, Response<DetailSidangResponse> response) {
                Log.e("Success", response.toString());
                DetailSidangResponse detailSidangResponse = response.body();

                    String tanggalSidang = detailSidangResponse.getTrialAt();
                    String jamMulaiSidang = detailSidangResponse.getStartAt();
                    String jamSelesaiSidang = detailSidangResponse.getEndAt();
                    String fileSlideSidang = detailSidangResponse.getFileSlide();
                    String fileJurnalSidang = detailSidangResponse.getFileJournal();
                    String nilaiSidang = detailSidangResponse.getGrade();

                    TextView tanggalSidangData = findViewById(R.id.tanggalSidang);
                    TextView jamMulaiSidangData = findViewById(R.id.jamMulaiSidang);
                    TextView jamSelesaiSidangData = findViewById(R.id.jamSelesaiSidang);

                    TextView nilaiSidangData = findViewById(R.id.nilaiSidang);
                    TextView fileSlideSidangData = findViewById(R.id.fileSlideSidang);
                    TextView fileJurnalSidangData = findViewById(R.id.fileJurnalSidang);

                    tanggalSidangData.setText(tanggalSidang);
                    jamMulaiSidangData.setText(jamMulaiSidang);
                    jamSelesaiSidangData.setText(jamSelesaiSidang);
                    nilaiSidangData.setText(nilaiSidang);
                    fileSlideSidangData.setText(fileSlideSidang);
                    fileJurnalSidangData.setText(fileJurnalSidang);

                try {
                    for (int a = 0 ; a<detailSidangResponse.getExaminers().size() ; a++){
                        String penguji = detailSidangResponse.getExaminers().get(a).getName();
                        list.add(penguji);
                    }
                    for (int b = 0; b < listexaminers.length; b++){
                        ((TextView)findViewById(listexaminers[b])).setText(list.get(b));
                    }

                }catch (IndexOutOfBoundsException e){

                }
                }

            @Override
            public void onFailure(Call<DetailSidangResponse> call, Throwable t) {
            Log.e("failure", t.getLocalizedMessage());
            }
        }));


    }
}