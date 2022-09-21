package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListMahasiswaActivity extends AppCompatActivity {

    ArrayList<mahasiswaCard> mahasiswacard = new ArrayList<>();

    int [] mahasiswaImage = {R.drawable.logounand};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        RecyclerView recyclerView = findViewById(R.id.mahasiswaList);

        setUpMahasiswaCard();

        CardAdapter adapter = new CardAdapter(this, mahasiswacard);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpMahasiswaCard()
    {
        String[] namaMahasiswa = getResources().getStringArray(R.array.mahasiswa_txt);
        String[] nimMahasiswa = getResources().getStringArray(R.array.nim_txt);

        for (int i = 0; i<namaMahasiswa.length; i++)
        {
            mahasiswacard.add(new mahasiswaCard(namaMahasiswa[i],nimMahasiswa[i],mahasiswaImage[i]));
        }
    }
}