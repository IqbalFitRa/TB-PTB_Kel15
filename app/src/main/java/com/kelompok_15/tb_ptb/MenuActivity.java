package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button buton, profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        profil = findViewById(R.id.profilMenu);
        profil.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent profilIn = new Intent(MenuActivity.this, LihatProfileActivity.class);
                startActivity(profilIn);
            }
        });


        buton = findViewById(R.id.listMahasiswaMenu);
        buton.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View view) {
                Intent listMahasiswa = new Intent(MenuActivity.this, MahasiswaActivity.class);
                startActivity(listMahasiswa);
            }
        });

    }
}