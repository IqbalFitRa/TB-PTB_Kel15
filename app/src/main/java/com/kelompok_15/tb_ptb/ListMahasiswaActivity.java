package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import com.kelompok_15.tb_ptb.adapters.AdapterMahasiswa;
import com.kelompok_15.tb_ptb.models.Mahasiswa;
import com.kelompok_15.tb_ptb.retrofit.MainInterface;
import com.kelompok_15.tb_ptb.retrofit.RetrofitClient;
import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.ListMahasiswaResponse;
import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.ThesesItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMahasiswaActivity extends AppCompatActivity {

    private RecyclerView rvMahasiswa;
    Button bimbingan;
    private AdapterMahasiswa adapter;
    String gettoken, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        bimbingan = findViewById(R.id.permintaanBimbingan2ListMahasiswa);
        bimbingan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bimbinganin = new Intent(ListMahasiswaActivity.this, ListPermintaanBimbinganActivity.class);
                startActivity(bimbinganin);
            }
        });

        rvMahasiswa = findViewById(R.id.rv_listmahasiswa);
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AdapterMahasiswa();
        rvMahasiswa.setAdapter(adapter);


        MainInterface mainInterface = RetrofitClient.getService();
        SharedPreferences sharedPreferences = getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY",MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token","");
        token = "Bearer " + gettoken;
        Toast.makeText(ListMahasiswaActivity.this, token, Toast.LENGTH_SHORT).show();

        Call<ListMahasiswaResponse> call = mainInterface.listmahasiswaresponse(token);
        call.enqueue(new Callback<ListMahasiswaResponse>() {
            @Override
            public void onResponse(Call<ListMahasiswaResponse> call, Response<ListMahasiswaResponse> response) {

                Log.d("ListMahasiswa-Debug", response.toString());
                ListMahasiswaResponse listMahasiswaResponse1 = response.body();
                if (listMahasiswaResponse1 != null){
                    List<ThesesItem> theses = listMahasiswaResponse1.getTheses();
                    adapter.setListMahasiswa((ArrayList<ThesesItem>) theses);

                }
            }

            @Override
            public void onFailure(Call<ListMahasiswaResponse> call, Throwable t) {

            }
        });


    }








   /* public ArrayList<Mahasiswa> getMahasiswa(){

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
        listMahasiswa.add(new Mahasiswa(
                null,
                "Errordikit",
                "2011524133"
        ));
        listMahasiswa.add(new Mahasiswa(
                null,
                "Pogramrunning",
                "2011524521"
        ));
        listMahasiswa.add(new Mahasiswa(
                null,
                "Brodokalah",
                "2011525321"
        ));

        return listMahasiswa;
    }

    @Override
    public void onItemMahasiswaClick(Mahasiswa mahasiswa) {
        Intent listmahasiswa = new Intent(this, DetailMahasiswaActivity.class);
        listmahasiswa.putExtra("NAMA_MAHASISWA", mahasiswa.getNama());
        //listmahasiswa.putExtra("NIM_MAHASISWA", mahasiswa.getNim());
        startActivity(listmahasiswa);
        //Toast.makeText(this, "OK....", Toast.LENGTH_SHORT).show();
    }*/

}