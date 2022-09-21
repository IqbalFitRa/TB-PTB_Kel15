package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }

    public void onButtonSimpanEditProfilClicked(View view) {
        Toast.makeText(this, "Profil Telah Berhasil Diubah", Toast.LENGTH_SHORT).show();
    }
}