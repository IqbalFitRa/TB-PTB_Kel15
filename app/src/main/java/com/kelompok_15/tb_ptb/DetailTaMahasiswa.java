package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kelompok_15.tb_ptb.retrofit.MainInterface;
import com.kelompok_15.tb_ptb.retrofit.RetrofitClient;
import com.kelompok_15.tb_ptb.retrofit.detailtamahasiswa.DetailTAResponse;
import com.kelompok_15.tb_ptb.retrofit.detailtamahasiswa.SupervisorsItem;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTaMahasiswa extends AppCompatActivity {

    Button inputNilai, batalTA, logBook, seminar, sidang;
    String gettoken,token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ta_mahasiswa);

//        getDetailTA();
//        getDetailTA2();


        sidang = findViewById(R.id.DetailsidangDetailTAMahasiswa);
        sidang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sidangIn = new Intent(DetailTaMahasiswa.this, DetailSidangActivity.class);
                startActivity(sidangIn);
            }
        });

        seminar = findViewById(R.id.DetailSeminarDetailTAMahasiswa);
        seminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seminarIn = new Intent(DetailTaMahasiswa.this, DetailSeminarActivity.class);
                startActivity(seminarIn);
            }
        });

        logBook = findViewById(R.id.ListLogbookDetailTAMahasiswa);
        logBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logBookIn = new Intent(DetailTaMahasiswa.this, ListLogBookActivity.class);
                startActivity(logBookIn);
            }
        });

        batalTA = findViewById(R.id.buttonDetailTA5FromBatal);
        batalTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent batalTAIn = new Intent(DetailTaMahasiswa.this, FormBatalActivity.class);
                startActivity(batalTAIn);
            }
        });

        inputNilai = findViewById(R.id.buttonInputDetailTA);
        inputNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inputNilaiIn = new Intent(DetailTaMahasiswa.this, InputNilaiActivity.class);
                startActivity(inputNilaiIn);
            }
        });
    }
//    public void getDetailTA() {
//        MainInterface mainInterface = RetrofitClient.getService();
//        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY", MODE_PRIVATE);
//        gettoken = sharedPreferences.getString("token", "");
//        token = "Bearer " + gettoken;
//        Toast.makeText(DetailTaMahasiswa.this, token, Toast.LENGTH_SHORT).show();
//
//        Call<DetailTAResponse> call = mainInterface.detailTaMahasiswaresponse(token);
//        call.enqueue(new Callback<DetailTAResponse>() {
//            @Override
//            public void onResponse(Call<DetailTAResponse> call, Response<DetailTAResponse> response) {
//
//                DetailTAResponse detailTAResponse = response.body();
//
//                getDetailTA2();
//
//                String judul    = detailTAResponse.getTitle();
//                String detail   = detailTAResponse.getJsonMemberAbstract();
//                String nama     = detailTAResponse.getStudent().getName();
//                String nim      = detailTAResponse.getStudent().getNim();
//
//
//
//                TextView castJudul  = findViewById(R.id.judul2DetailTA);
//                TextView castDetail = findViewById(R.id.ringkasan2DetailTA);
//                TextView castnama   = findViewById(R.id.namaDetailTA);
//                TextView castnim    = findViewById(R.id.nimDetailTA);
//
//
//                castJudul.setText(judul);
//                castDetail.setText(detail);
//                castnama.setText(nama);
//                castnim.setText(nim);
//
//            }
//
//            @Override
//            public void onFailure(Call<DetailTAResponse> call, Throwable t) {
//                Log.e("Log.fail", t.getLocalizedMessage());
//
//            }
//        });
//
//    }
//    public  void getDetailTA2() {
//        MainInterface mainInterface = RetrofitClient.getService();
//        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY", MODE_PRIVATE);
//        gettoken = sharedPreferences.getString("token", "");
//        token = "Bearer " + gettoken;
//        Toast.makeText(DetailTaMahasiswa.this, token, Toast.LENGTH_SHORT).show();
//
//        Call<SupervisorsItem> call = mainInterface.supervisors(token);
//        call.enqueue(new Callback<SupervisorsItem>() {
//            @Override
//            public void onResponse(Call<SupervisorsItem> call, Response<SupervisorsItem> response) {
//                Log.e("test", response.toString());
//
//                SupervisorsItem supervisorsItem = response.body();
//
//                String namasv1 = supervisorsItem.getName();
//
//                TextView namasv = findViewById(R.id.pembimbing11DetailTA);
//
//                namasv.setText(namasv1);
//
//
//            }
//
//            @Override
//            public void onFailure(Call<SupervisorsItem> call, Throwable t) {
//                Log.e("Fail", t.getLocalizedMessage());
//            }
//        });
    }
