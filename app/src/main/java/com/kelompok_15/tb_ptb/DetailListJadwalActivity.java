package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DetailListJadwalActivity extends AppCompatActivity {

    Button jadwalSidang, jadwalSeminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_jadwal);

        jadwalSidang = findViewById(R.id.buttonDetailSidang);
        jadwalSidang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jadwalSidangIn = new Intent(DetailListJadwalActivity.this,ListJadwalSidangActivity.class);
                startActivity(jadwalSidangIn);
            }
        });

        jadwalSeminar = findViewById(R.id.buttonDetailSeminar);
        jadwalSeminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jadwalSeminarIn = new Intent(DetailListJadwalActivity.this,ListJadwalSeminarActivity.class);
                startActivity(jadwalSeminarIn);
            }
        });
    }
}