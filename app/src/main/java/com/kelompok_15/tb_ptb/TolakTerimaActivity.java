package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TolakTerimaActivity extends AppCompatActivity {

    Button terima,tolak;
    String namaMahasiswaPB;
    TextView textViewNamaMahasiswaPB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tolak_terima);

        Intent listpb = getIntent();
        if (listpb != null){
            namaMahasiswaPB = listpb.getStringExtra("NAMA_MAHASISWA");
            textViewNamaMahasiswaPB = findViewById(R.id.textViewNamaMahasiswaPB);
            textViewNamaMahasiswaPB.setText(namaMahasiswaPB);
        }

        terima = findViewById(R.id.TerimaTolakTerima);
        terima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TolakTerimaActivity.this, "Diterima", Toast.LENGTH_SHORT).show();
            }
        });

        tolak = findViewById(R.id.TolakTolakTerima);
        tolak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TolakTerimaActivity.this, "Tolak", Toast.LENGTH_SHORT).show();
            }
        });
    }
}