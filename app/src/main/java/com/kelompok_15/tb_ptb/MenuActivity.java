package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kelompok_15.tb_ptb.retrofit.LogoutResponse;
import com.kelompok_15.tb_ptb.retrofit.MainInterface;
import com.kelompok_15.tb_ptb.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {

    Button buton, profil, jadwal, logout;
    String gettoken, token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        jadwal = findViewById(R.id.jadwalSeminarMenu);
        jadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jadwalIn = new Intent(MenuActivity.this, ListJadwalSeminarDanSidangActivity.class);
                startActivity(jadwalIn);
            }
        });

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
                Intent listMahasiswa = new Intent(MenuActivity.this, ListMahasiswaActivity.class);
                startActivity(listMahasiswa);
            }
        });

        logout = findViewById(R.id.logoutakun);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainInterface mainInterface = RetrofitClient.getService();
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY",MODE_PRIVATE);
                gettoken = sharedPreferences.getString("token","");
                token = "Bearer " + gettoken;

                Call<LogoutResponse> call = mainInterface.logout("token");
                call.enqueue(new Callback<LogoutResponse>() {
                    @Override
                    public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {

                       LogoutResponse logoutResponse = response.body();
                       SharedPreferences.Editor editor = sharedPreferences.edit();
                       editor.remove("token");
                       editor.apply();
                       finish();
                       Toast.makeText(MenuActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                       startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<LogoutResponse> call, Throwable t) {

                    }
                });

            }
        });

    }
}