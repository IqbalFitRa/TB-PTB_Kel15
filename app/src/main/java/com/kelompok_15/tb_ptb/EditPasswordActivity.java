package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EditPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);
    }

    public void onButtonSimpanGantiPasswordClicked(View view) {
        Toast.makeText(this, "Password Telah Berhasil Diubah", Toast.LENGTH_SHORT).show();
    }
}