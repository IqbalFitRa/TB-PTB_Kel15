package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kelompok_15.tb_ptb.retrofit.MainInterface;
import com.kelompok_15.tb_ptb.retrofit.RetrofitClient;
import com.kelompok_15.tb_ptb.retrofit.detailmahasiswa.DetailMahasiswaResponse;
import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.ListMahasiswaResponse;
import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.Student;
import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.ThesesItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMahasiswaActivity extends AppCompatActivity {

    Button button;
    String namaMahasiswa, nimMahasiswa;
    TextView namaDetailMahasiswa, nimDetailMahasiswa;
    String gettoken,token;
    public ImageView imageProfil2;
    public TextView nama2, nim2, tempatlhr, tanggallhr, nohp;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        imageProfil2 = findViewById(R.id.imageViewDetailMahasiswa);
        nama2 = findViewById(R.id.namaDetailMahasiswa);
        nim2 = findViewById(R.id.nimDetailMahasiswa);
        tempatlhr = findViewById(R.id.tempattaggallahirDetailMahasiswa);
        tanggallhr = findViewById(R.id.emailDetailMahasiswa);
        nohp = findViewById(R.id.noHPDetailMahasiswa);

        Intent intent = getIntent();
        if (intent.getExtras() != null){

            student = (Student) intent.getSerializableExtra("data");

            String nama = student.getName();
            String nim = student.getNim();
            String tmptlhr = student.getBirthplace();
            String tnggllhr = student.getBirthday();
            String nohp1 = student.getPhone();


            nama2.setText(nama);
            nim2.setText(nim);
            tempatlhr.setText(tmptlhr);
            tanggallhr.setText(tnggllhr);
            nohp.setText(nohp1);
        }


        /*
        button = findViewById(R.id.DetailTADetailMahasiswa);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainInterface mainInterface = RetrofitClient.getService();
                SharedPreferences sharedPreferences = getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY",MODE_PRIVATE);
                gettoken = sharedPreferences.getString("token","");
                token = "Bearer " + gettoken;
                Toast.makeText(DetailMahasiswaActivity.this, token, Toast.LENGTH_SHORT).show();

                Call<ListMahasiswaResponse> call = mainInterface.listmahasiswaresponse(token);
                call.enqueue(new Callback<ListMahasiswaResponse>() {
                    @Override
                    public void onResponse(Call<ListMahasiswaResponse> call, Response<ListMahasiswaResponse> response) {

                        Log.d("DetailMahasiswa-Debug", response.toString());
                        ListMahasiswaResponse listMahasiswaResponse = response.body();


                    }

                    @Override
                    public void onFailure(Call<ListMahasiswaResponse> call, Throwable t) {

                    }
                });


                Intent detailTAin = new Intent(DetailMahasiswaActivity.this, DetailTaMahasiswa.class);
                startActivity(detailTAin);
            }
        });*/

        /*Intent listmahasiswa = getIntent();
        if (listmahasiswa != null){
            namaMahasiswa = listmahasiswa.getStringExtra("NAMA_MAHASISWA");
            namaDetailMahasiswa = findViewById(R.id.namaDetailMahasiswa);
            namaDetailMahasiswa.setText(namaMahasiswa);

            /*nimDetailMahasiswa = findViewById(R.id.nimDetailMahasiswa);
            nimDetailMahasiswa.setText(nimMahasiswa);
        }*/

    }
}