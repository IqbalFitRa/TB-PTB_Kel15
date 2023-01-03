package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.kelompok_15.tb_ptb.adapters.AdapterJadwal;
import com.kelompok_15.tb_ptb.models.JadwalMahasiswaSidang;
import com.kelompok_15.tb_ptb.retrofit.MainInterface;
import com.kelompok_15.tb_ptb.retrofit.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class ListJadwalMahasiswaSidangActivity extends AppCompatActivity implements AdapterJadwal.ItemJadwalClickListener {

    private RecyclerView recyclerjadwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal_mahasiswa_sidang);

        SharedPreferences sharedPreferences = getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY",MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");

        recyclerjadwal = findViewById(R.id.recycler_jadwal_seminar);

        AdapterJadwal adapter = new AdapterJadwal(getJadwal());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this );

        recyclerjadwal.setLayoutManager(layoutManager);
        recyclerjadwal.setAdapter(adapter);

        //minta data ke server
        //MainInterface mainInterface = RetrofitClient.getService();
        //Call<ListSidang> call = mainInterface.listsidang("Bearer " + token);
    }

    public ArrayList<JadwalMahasiswaSidang> getJadwal(){
        ArrayList<JadwalMahasiswaSidang> ListJadwal = new ArrayList<>();
        ListJadwal.add(new JadwalMahasiswaSidang(
                null,
                "Kurnia Aziz",
                "1811522002",
                "Senin, 12 September 2022"
        ));
        ListJadwal.add(new JadwalMahasiswaSidang(
                null,
                "Jefri Alam",
                "1811521009",
                "Senin, 12 September 2022"
        ));
        ListJadwal.add(new JadwalMahasiswaSidang(
                null,
                "Selena Putri",
                "1411521002",
                "Kamis, 15 September 2022"
        ));
        ListJadwal.add(new JadwalMahasiswaSidang(
                null,
                "Grace Aulia",
                "1611522027",
                "Kamis, 15 September 2022"
        ));
        ListJadwal.add(new JadwalMahasiswaSidang(
                null,
                "Susan Susanti",
                "1811522026",
                "Senin, 26 September 2022"
        ));
        ListJadwal.add(new JadwalMahasiswaSidang(
                null,
                "Lauren Floria",
                "1711523009",
                "Senin, 26 September 2022"
        ));
        ListJadwal.add(new JadwalMahasiswaSidang(
                null,
                "Kurnia Aziz",
                "1811522002",
                "Senin, 12 September 2022"
        ));
        ListJadwal.add(new JadwalMahasiswaSidang(
                null,
                "Jefri Alam",
                "1811521009",
                "Senin, 12 September 2022"
        ));
        ListJadwal.add(new JadwalMahasiswaSidang(
                null,
                "Selena Putri",
                "1411521002",
                "Kamis, 15 September 2022"
        ));
        ListJadwal.add(new JadwalMahasiswaSidang(
                null,
                "Grace Aulia",
                "1611522027",
                "Kamis, 15 September 2022"
        ));
        ListJadwal.add(new JadwalMahasiswaSidang(
                null,
                "Susan Susanti",
                "1811522026",
                "Senin, 26 September 2022"
        ));
        ListJadwal.add(new JadwalMahasiswaSidang(
                null,
                "Lauren Floria",
                "1711523009",
                "Senin, 26 September 2022"
        ));

        return ListJadwal;

    }

    @Override
    public void onItemJadwalClick(JadwalMahasiswaSidang jadwal) {
        startActivity(new Intent(getApplicationContext(), ListJadwalSidangActivity.class));
    }
}