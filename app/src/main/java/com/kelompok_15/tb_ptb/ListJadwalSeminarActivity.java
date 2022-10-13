package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListJadwalSeminarActivity extends AppCompatActivity {

    Button menambahkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal_seminar);

        menambahkan = findViewById(R.id.buttonsidang1);
        menambahkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menambahkan = new Intent(ListJadwalSeminarActivity.this, rekomendasiSidangActivity.class);
                startActivity(menambahkan);

            }
        });
    }
}