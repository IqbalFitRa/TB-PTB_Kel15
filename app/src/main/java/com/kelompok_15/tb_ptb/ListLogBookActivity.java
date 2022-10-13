package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.kelompok_15.tb_ptb.adapters.AdapterLogbook;
import com.kelompok_15.tb_ptb.models.Logbook;

import java.util.ArrayList;

public class ListLogBookActivity extends AppCompatActivity implements  AdapterLogbook.ItemLogbookClickListener{

    private RecyclerView rvLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_log_book);

        rvLogbook = findViewById(R.id.list_logbook);

        AdapterLogbook adapter = new AdapterLogbook(getLogbook());
        adapter.setListenerIL(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvLogbook.setLayoutManager(layoutManager);
        rvLogbook.setAdapter(adapter);
    }

    public ArrayList<Logbook> getLogbook(){
        ArrayList<Logbook> listLogbook = new ArrayList<>();
        listLogbook.add(new Logbook(
                "Konsultasi Alternatif Judul Tugas Akhir",
                "Senin, 17 Juli 2022"

        ));
        listLogbook.add(new Logbook(
                "Revisi BAB 1",
                "Selasa, 17 Agustus 2022"

        ));
        listLogbook.add(new Logbook(
                "Revisi BAB 2",
                "Selasa, 19 Agustus 2022"

        ));
        listLogbook.add(new Logbook(
                "Revisi BAB 2 PART 2",
                "Selasa, 24 Agustus 2022"

        ));
        listLogbook.add(new Logbook(
                "Revisi BAB 2 PART 3",
                "Selasa, 28 Agustus 2022"

        ));
        listLogbook.add(new Logbook(
                "Revisi BAB 2 PART 4",
                "Selasa, 1 September 2022"

        ));
        listLogbook.add(new Logbook(
                "Revisi BAB 3",
                "Selasa, 19 September 2022"

        ));
        listLogbook.add(new Logbook(
                "Revisi BAB 3 PART 2",
                "Selasa, 19 September 2022"

        ));
        listLogbook.add(new Logbook(
                "Revisi BAB 3 PART 3",
                "Selasa, 19 September 2022"

        ));
        listLogbook.add(new Logbook(
                "Revisi BAB 3 PART 5",
                "Selasa, 19 September 2022"

        ));
        return listLogbook;
    }

    @Override
    public void  onItemLogbookClick(Logbook logbook){
        Intent listLogbookIn = new Intent(this, DetailLogBookActivity.class);
        startActivity(listLogbookIn);
    }
}