package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.kelompok_15.tb_ptb.adapters.AdapterJadwal;
import com.kelompok_15.tb_ptb.models.JadwalSeminardanSidang;

import java.util.ArrayList;

public class ListJadwalSeminarDanSidangActivity extends AppCompatActivity implements AdapterJadwal.ItemJadwalClickListener {

    private RecyclerView recyclerjadwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal_seminar_dan_sidang);

        recyclerjadwal = findViewById(R.id.recycler_jadwal);

        AdapterJadwal adapter = new AdapterJadwal(getJadwal());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this );

        recyclerjadwal.setLayoutManager(layoutManager);
        recyclerjadwal.setAdapter(adapter);
    }

    public ArrayList<JadwalSeminardanSidang> getJadwal(){
        ArrayList<JadwalSeminardanSidang> ListJadwal = new ArrayList<>();
        ListJadwal.add(new JadwalSeminardanSidang(
                null,
                "Kurnia Aziz",
                "1811522002",
                "Senin, 12 September 2022"
        ));
        ListJadwal.add(new JadwalSeminardanSidang(
                null,
                "Jefri Alam",
                "1811521009",
                "Senin, 12 September 2022"
        ));
        ListJadwal.add(new JadwalSeminardanSidang(
                null,
                "Selena Putri",
                "1411521002",
                "Kamis, 15 September 2022"
        ));
        ListJadwal.add(new JadwalSeminardanSidang(
                null,
                "Grace Aulia",
                "1611522027",
                "Kamis, 15 September 2022"
        ));
        ListJadwal.add(new JadwalSeminardanSidang(
                null,
                "Susan Susanti",
                "1811522026",
                "Senin, 26 September 2022"
        ));
        ListJadwal.add(new JadwalSeminardanSidang(
                null,
                "Lauren Floria",
                "1711523009",
                "Senin, 26 September 2022"
        ));
        ListJadwal.add(new JadwalSeminardanSidang(
                null,
                "Andi Kurniawan",
                "1711523010",
                "Kamis, 29 September 2022"
        ));


        return ListJadwal;

    }

    @Override
    public void onItemJadwalClick(JadwalSeminardanSidang jadwal) {
        startActivity(new Intent(getApplicationContext(), DetailListJadwalActivity.class));
    }
}