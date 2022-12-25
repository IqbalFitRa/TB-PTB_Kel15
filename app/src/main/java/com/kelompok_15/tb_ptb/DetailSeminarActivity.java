package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailSeminarActivity extends AppCompatActivity {

    Button pesertaseminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seminar);

        pesertaseminar = findViewById(R.id.pesertaseminar);
        pesertaseminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pesertaseminar = new Intent(DetailSeminarActivity.this, SeminarMahasiswaActivity.class);
                startActivity(pesertaseminar);
            }
        });
    }
}