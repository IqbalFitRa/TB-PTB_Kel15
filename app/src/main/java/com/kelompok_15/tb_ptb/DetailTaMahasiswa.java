package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailTaMahasiswa extends AppCompatActivity {

    Button inputNilai, batalTA, logBook, seminar, sidang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ta_mahasiswa);

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
        Intent detailIntent = getIntent();
        if (detailIntent != null){

//            student = (Student) detailIntent.getSerializableExtra("data");
//
//            String nama = student.getName();
//            String nim = student.getNim();
//            String tempat = student.getBirthplace();
//            String tanggal = student.getBirthday();
//            String nomor = student.getPhone();
//
//            nama2.setText(nama);
//            nim2.setText(nim);
//            tempatlhr.setText(tempat);
//            tanggallhr.setText(tanggal);
//            nohp.setText(nomor);

            String namaMahasiswa = detailIntent.getStringExtra("NAMA_MAHASISWA");
            TextView textNamaMahasiswa = findViewById(R.id.namaDetailTA);
            textNamaMahasiswa.setText(namaMahasiswa);
        }
    }
}