package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.kelompok_15.tb_ptb.adapters.AdapterJadwal;
import com.kelompok_15.tb_ptb.models.JadwalMahasiswaSidang;
import com.kelompok_15.tb_ptb.retrofit.ListJadwal;
import com.kelompok_15.tb_ptb.retrofit.ListJadwalSidangItem;
import com.kelompok_15.tb_ptb.retrofit.MainInterface;
import com.kelompok_15.tb_ptb.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListJadwalMahasiswaSidangActivity extends AppCompatActivity implements AdapterJadwal.ItemJadwalClickListener {

    private RecyclerView recyclerjadwal;
    private AdapterJadwal adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal_mahasiswa_sidang);

        SharedPreferences sharedPreferences = getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY",MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");

        recyclerjadwal = findViewById(R.id.recycler_jadwal_seminar);
        recyclerjadwal.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AdapterJadwal(this::ClickedJadwal);
        recyclerjadwal.setAdapter(adapter);

        /*recyclerjadwal = findViewById(R.id.recycler_jadwal_seminar);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this );

        AdapterJadwal adapter = new AdapterJadwal(getJadwal());
        adapter.setListener(this);
        recyclerjadwal.setAdapter(adapter);*/

        //minta data ke server
        MainInterface mainInterface = RetrofitClient.getService();
        Call<ListJadwal> call = mainInterface.listjadwal (209, "Bearer " + token);
        call.enqueue(new Callback<ListJadwal>() {
            @Override
            public void onResponse(Call<ListJadwal> call, Response<ListJadwal> response) {

                ListJadwal listJadwal = response,body();
                if(listJadwal != null){
                    List<ListJadwalSidangItem> seminars = listJadwal.getSeminars();
                    adapter.setItemList(seminars);
                    recyclerjadwal.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListJadwal> call, Throwable t){
                Log.d("failure", t.getLocalizedMessage());
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