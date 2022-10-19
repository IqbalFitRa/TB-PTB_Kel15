package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kelompok_15.tb_ptb.adapters.AdapterPB;
import com.kelompok_15.tb_ptb.models.PermintaanBimbingan;

import java.util.ArrayList;

public class ListPermintaanBimbinganActivity extends AppCompatActivity implements AdapterPB.ItemPBClickListener{

    private RecyclerView rv_permintaanBimbingan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_permintaanbimbingan);

        rv_permintaanBimbingan = findViewById(R.id.rv_pb);

        AdapterPB adapter = new AdapterPB(getPermintaanBimbingan());
        adapter.setListenerPB(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rv_permintaanBimbingan.setLayoutManager(layoutManager);
        rv_permintaanBimbingan.setAdapter(adapter);
    }

    public ArrayList<PermintaanBimbingan> getPermintaanBimbingan(){

        ArrayList<PermintaanBimbingan> listPB = new ArrayList<>();
        listPB.add(new PermintaanBimbingan(
                null,
                "PucukMelati",
                "2011521945"
        ));
        listPB.add(new PermintaanBimbingan(
                null,
                "TangkaiMawar",
                "2011521944"
        ));
        listPB.add(new PermintaanBimbingan(
                null,
                "Rambutminsatu",
                "2011525532"
        ));
        listPB.add(new PermintaanBimbingan(
                null,
                "Rambutmindua",
                "2011525532"
        ));
        listPB.add(new PermintaanBimbingan(
                null,
                "Rambutminsatupuluh",
                "2011525532"
        ));
        return listPB;
    }

    @Override
    public void onItemPBClick(PermintaanBimbingan permintaanBimbingan) {
        Intent listpb = new Intent(this, TolakTerimaActivity.class);
        listpb.putExtra("NAMA_MAHASISWA", permintaanBimbingan.getNama());
        startActivity(listpb);
    }
}
