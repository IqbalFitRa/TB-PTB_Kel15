package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailMahasiswaActivity extends AppCompatActivity {

    Button button;
    String namaMahasiswa, nimMahasiswa;
    TextView namaDetailMahasiswa, nimDetailMahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        button = findViewById(R.id.DetailTADetailMahasiswa);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailTAin = new Intent(DetailMahasiswaActivity.this, DetailTaMahasiswa.class);
                startActivity(detailTAin);
            }
        });

        Intent listmahasiswa = getIntent();
        if (listmahasiswa != null){
            namaMahasiswa = listmahasiswa.getStringExtra("NAMA_MAHASISWA");
            namaDetailMahasiswa = findViewById(R.id.namaDetailMahasiswa);
            namaDetailMahasiswa.setText(namaMahasiswa);

            /*nimDetailMahasiswa = findViewById(R.id.nimDetailMahasiswa);
            nimDetailMahasiswa.setText(nimMahasiswa);*/
        }

    }
}