package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EditPasswordActivity extends AppCompatActivity {

    //private EditText editPassLama, editPassBaru, editKonfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);

        //editPassLama = findViewById(R.id.inputPasswordLama);
        //editPassBaru = findViewById(R.id.inputPasswordBaru);
        //editKonfirmPass = findViewById(R.id.konfirmasiPasswordBaru);

        // object db
       // AppDatabase db = Room.databaseBuilder(getApplicationContext(),
       //         AppDatabase.class, "database-pass").build();

        // object dao
       // PassDao passDao = db.passDao();

       // Pass password = new Pass();
       // password.PassLama = PassLama;
       // password.PassBaru = PassBaru;
      //  password.KomfirmPass = KomfirmPass;

       //  passDao.insert(password);

    }



    public void onButtonSimpanGantiPasswordClicked(View view) {
        Toast.makeText(this, "Password Telah Berhasil Diubah", Toast.LENGTH_SHORT).show();
    }



    //public void onButtonBackToPreviousPageClicked1(View view) {
        //startActivity(new Intent(getApplicationContext(), LihatProfileActivity.class));
    //}
}