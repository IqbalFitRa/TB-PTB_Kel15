package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LihatProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_profile);
    }

    public void onButtonEditProfilClicked(View view) {
        startActivity(new Intent(getApplicationContext(), EditProfileActivity.class));
    }

    public void onButtonEditPasswordClicked(View view) {
        startActivity(new Intent(getApplicationContext(), EditPasswordActivity.class));
    }
}