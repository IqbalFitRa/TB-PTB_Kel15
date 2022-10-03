package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kelompok_15.tb_ptb.adapters.AdapterMahasiswa;
import com.kelompok_15.tb_ptb.models.Mahasiswa;

import java.util.ArrayList;

public class ListMahasiswaActivity extends AppCompatActivity {

    private RecyclerView rvMahasiswa;
    Button bimbingan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        bimbingan = findViewById(R.id.permintaanBimbingan2ListMahasiswa);
        bimbingan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bimbinganin = new Intent(ListMahasiswaActivity.this, PersetujuanBimbinganActivity.class);
                startActivity(bimbinganin);
            }
        });

        rvMahasiswa = findViewById(R.id.rv_listmahasiswa);

        AdapterMahasiswa adapter = new AdapterMahasiswa(getMahasiswa());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvMahasiswa.setLayoutManager(layoutManager);
        rvMahasiswa.setAdapter(adapter);
    }


    public ArrayList<Mahasiswa> getMahasiswa(){

        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        listMahasiswa.add(new Mahasiswa(
                null,
                "AntooKeren",
                "2011529033"
        ));
        listMahasiswa.add(new Mahasiswa(
                null,
                "KambingFristail",
                "2011528891"
        ));
        listMahasiswa.add(new Mahasiswa(
                null,
                "MaimunahNyeker",
                "2011528894"
        ));
        listMahasiswa.add(new Mahasiswa(
                null,
                "TempelengHepi",
                "2011527811"
        ));
        listMahasiswa.add(new Mahasiswa(
                null,
                "PalaOerang",
                "2011528145"
        ));
        listMahasiswa.add(new Mahasiswa(
                null,
                "MantapNgkError",
                "2011524114"
        ));

        return listMahasiswa;
    }
}