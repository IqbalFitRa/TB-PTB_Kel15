package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.kelompok_15.tb_ptb.adapters.AdapterJadwal2;
import com.kelompok_15.tb_ptb.models.JadwalMahasiswaSeminar;

import java.util.ArrayList;

public class ListJadwalMahasiswaSeminarActivity extends AppCompatActivity implements AdapterJadwal2.ItemJadwalClickListener {

    private RecyclerView recyclerjadwal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal_mahasiswa_seminar);

        recyclerjadwal2 = findViewById(R.id.recycler_jadwal_seminar);

        AdapterJadwal2 adapter = new AdapterJadwal2(getJadwal2());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this );

        recyclerjadwal2.setLayoutManager(layoutManager);
        recyclerjadwal2.setAdapter(adapter);
    }
    public ArrayList<JadwalMahasiswaSeminar> getJadwal2(){
        ArrayList<JadwalMahasiswaSeminar> ListJadwal2 = new ArrayList<>();
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Kurnia Aziz",
                "1811522002",
                "Senin, 12 September 2022"
        ));
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Jefri Alam",
                "1811521009",
                "Senin, 12 September 2022"
        ));
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Selena Putri",
                "1411521002",
                "Kamis, 15 September 2022"
        ));
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Grace Aulia",
                "1611522027",
                "Kamis, 15 September 2022"
        ));
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Susan Susanti",
                "1811522026",
                "Senin, 26 September 2022"
        ));
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Lauren Floria",
                "1711523009",
                "Senin, 26 September 2022"
        ));
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Andi Kurniawan",
                "1711523010",
                "Kamis, 29 September 2022"
        ));
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Kurnia Aziz",
                "1811522002",
                "Senin, 12 September 2022"
        ));
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Jefri Alam",
                "1811521009",
                "Senin, 12 September 2022"
        ));
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Selena Putri",
                "1411521002",
                "Kamis, 15 September 2022"
        ));
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Grace Aulia",
                "1611522027",
                "Kamis, 15 September 2022"
        ));
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Susan Susanti",
                "1811522026",
                "Senin, 26 September 2022"
        ));
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Lauren Floria",
                "1711523009",
                "Senin, 26 September 2022"
        ));
        ListJadwal2.add(new JadwalMahasiswaSeminar(
                null,
                "Andi Kurniawan",
                "1711523010",
                "Kamis, 29 September 2022"
        ));


        return ListJadwal2;

    }

    @Override
    public void onItemJadwalClick(JadwalMahasiswaSeminar jadwal2) {
        startActivity(new Intent(getApplicationContext(), ListJadwalSeminarActivity.class));
    }

}