package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DetailListJadwalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_jadwal);
    }

    public void onButtonSidangClicked(View view) {
        startActivity(new Intent(getApplicationContext(), ListJadwalSidangActivity.class));
    }

    public void onButtonSeminarClicked(View view) {
        startActivity(new Intent(getApplicationContext(), ListJadwalSeminarActivity.class));
    }
}