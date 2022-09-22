package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MahasiswaActivity extends AppCompatActivity {

    Button detailTA,permintaanBimbingan;
    ImageButton detailMa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);

        permintaanBimbingan = findViewById(R.id.permintaanBimbingan);
        permintaanBimbingan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent permintaanBimbinganIn = new Intent(MahasiswaActivity.this, PersetujuanBimbinganActivity.class);
                startActivity(permintaanBimbinganIn);
            }
        });

        detailMa = findViewById(R.id.detailMahasiswa);
        detailMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailMaIn = new Intent(MahasiswaActivity.this, DetailMahasiswaActivity.class);
                startActivity(detailMaIn);
            }
        });

        detailTA = findViewById(R.id.detailTAMahasiswa);
        detailTA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent detailTAIn = new Intent(MahasiswaActivity.this,DetailTaMahasiswa.class);
                startActivity(detailTAIn);
            }
        });
    }
}