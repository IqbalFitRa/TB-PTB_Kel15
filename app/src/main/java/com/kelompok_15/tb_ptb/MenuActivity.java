package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn = findViewById(R.id.listMahasiswa);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, ListMahasiswaActivity.class);
                startActivity(intent);
            }
        });

    }
}