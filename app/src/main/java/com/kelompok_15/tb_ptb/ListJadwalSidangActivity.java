package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.View;
import android.widget.Button;

public class ListJadwalSidangActivity extends AppCompatActivity {

    Button rumusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal_sidang);

        rumusan = findViewById(R.id.buttonsidang1);
        rumusan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rumusan = new Intent(ListJadwalSidangActivity.this, InputNilaiSidangActivity.class);
                startActivity(rumusan);
            }
        });
    }
}