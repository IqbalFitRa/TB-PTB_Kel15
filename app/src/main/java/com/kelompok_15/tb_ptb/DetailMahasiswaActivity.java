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

import com.kelompok_15.tb_ptb.retrofit.MainInterface;
import com.kelompok_15.tb_ptb.retrofit.RetrofitClient;
import com.kelompok_15.tb_ptb.retrofit.detailMahasiswaReal.DetailMahasiswa1Response;
import com.kelompok_15.tb_ptb.retrofit.detailMahasiswaReal.TrialsItem;
import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.Student;
import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.ThesesItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMahasiswaActivity extends AppCompatActivity {

    Button button;
    String namaMahasiswa, nimMahasiswa;

    String gettoken, token;
    public ImageView imageProfil2;
    public TextView nama2, nim2, tempatlhr, tanggallhr, nohp;
    Student student;
    ThesesItem thesesItem;
    Intent detailIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

//        getDetailMahasiswa();

////        jan dihapus
        detailIntent = getIntent();
        if (detailIntent != null) {


            MainInterface mainInterface = RetrofitClient.getService();
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY", MODE_PRIVATE);
            gettoken = sharedPreferences.getString("token", "");
            token = "Bearer " + gettoken;
//            Toast.makeText(DetailMahasiswaActivity.this, token, Toast.LENGTH_SHORT).show();
            Log.e("Token" ,token );

            int idstudent = detailIntent.getIntExtra("ID", 0);

            Call<DetailMahasiswa1Response> call = mainInterface.detailMahasiswa(token, idstudent);
            call.enqueue(new Callback<DetailMahasiswa1Response>() {
                @Override
                public void onResponse(Call<DetailMahasiswa1Response> call, Response<DetailMahasiswa1Response> response) {

                    Log.e("Suc", response.toString());
                    DetailMahasiswa1Response detailMahasiswa1Response = response.body();

                    TextView castnama = findViewById(R.id.namaDetailMahasiswa);
                    TextView castNim = findViewById(R.id.nimDetailMahasiswa);
                    TextView casttnggl = findViewById(R.id.email2DetailMahasiswa);
                    TextView casttempat = findViewById(R.id.tepattanggallahir2DetailMahasiswa);
                    TextView castnohp = findViewById(R.id.noHP2DetailMahasiswa);

                    String nama = detailMahasiswa1Response.getStudent().getName();
                    String nim = detailMahasiswa1Response.getStudent().getNim();
                    String tanggl = detailMahasiswa1Response.getStudent().getBirthday();
                    String tempat = detailMahasiswa1Response.getStudent().getBirthplace();
                    String nohp = detailMahasiswa1Response.getStudent().getPhone();

                    castnama.setText(nama);
                    castNim.setText(nim);
                    casttnggl.setText(tanggl);
                    casttempat.setText(tempat);
                    castnohp.setText(nohp);

                }

                @Override
                public void onFailure(Call<DetailMahasiswa1Response> call, Throwable t) {
                    Log.e("error", t.getLocalizedMessage());
                }
            });

            button = findViewById(R.id.DetailTADetailMahasiswa);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int idmaha = idstudent;

                    Intent intentExtra = new Intent(DetailMahasiswaActivity.this, DetailTaMahasiswa.class);
                    intentExtra.putExtra("id", idmaha);
                    startActivity(intentExtra);
                }
            });

//        Call<DetailMahasiswaResponse> call = mainInterface.detailmahasiswaresponse(token, idstudent);
//        call.enqueue(new Callback<DetailMahasiswaResponse>() {
//            @Override
//            public void onResponse(Call<DetailMahasiswaResponse> call, Response<DetailMahasiswaResponse> response) {
//
//                DetailMahasiswaResponse detailMahasiswaResponse = response.body();
//                castNim.setText(detailMahasiswaResponse.gets);
//            }
//
//            @Override
//            public void onFailure(Call<DetailMahasiswaResponse> call, Throwable t) {
//                Log.e("T", t.getLocalizedMessage());
//            }
//        });
//
//

//        imageProfil2 = findViewById(R.id.imageViewDetailMahasiswa);
//        nama2 = findViewById(R.id.namaDetailMahasiswa);
//        nim2 = findViewById(R.id.nimDetailMahasiswa);
//        tempatlhr = findViewById(R.id.tempattaggallahirDetailMahasiswa);
//        tanggallhr = findViewById(R.id.emailDetailMahasiswa);
//        nohp = findViewById(R.id.noHPDetailMahasiswa);
//
//        Intent intent = getIntent();
//        if (intent.getExtras() != null){
//
//            student = (Student) intent.getSerializableExtra("data");
//
//            String nama = student.getName();
//            String nim = student.getNim();
//            String tmptlhr = student.getBirthplace();
//            String tnggllhr = student.getBirthday();
//            String nohp1 = student.getPhone();
//
//
//            nama2.setText(nama);
//            nim2.setText(nim);
//            tempatlhr.setText(tmptlhr);
//            tanggallhr.setText(tnggllhr);
//            nohp.setText(nohp1);
        }


    /*Intent listmahasiswa = getIntent();
    if (listmahasiswa != null){
        namaMahasiswa = listmahasiswa.getStringExtra("NAMA_MAHASISWA");
        namaDetailMahasiswa = findViewById(R.id.namaDetailMahasiswa);
        namaDetailMahasiswa.setText(namaMahasiswa);

        /*nimDetailMahasiswa = findViewById(R.id.nimDetailMahasiswa);
        nimDetailMahasiswa.setText(nimMahasiswa);
    }*/
//    public void getDetailMahasiswa() {
//
//        MainInterface mainInterface = RetrofitClient.getService();
//        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY", MODE_PRIVATE);
//        gettoken = sharedPreferences.getString("token", "");
//        token = "Bearer " + gettoken;
//        Toast.makeText(DetailMahasiswaActivity.this, token, Toast.LENGTH_SHORT).show();


//        Call<ThesesItem> call = mainInterface.theseitems(token);
//        call.enqueue(new Callback<ThesesItem>() {
//            @Override
//            public void onResponse(Call<ThesesItem> call, Response<ThesesItem> response) {
//
//                Log.e("Succ-", response.toString());
//                ThesesItem thesesItem = response.body();
//
//                String nama = thesesItem.getStudent().getName();
//                String nim = thesesItem.getStudent().getNim();
//                String tanggallahir = thesesItem.getStudent().getBirthplace();
//                String tempatlahir = thesesItem.getStudent().getBirthday();
//                String noHp = thesesItem.getStudent().getPhone();
//
//                TextView castNama = findViewById(R.id.namaDetailMahasiswa);
//                TextView castNim =  findViewById(R.id.nimDetailMahasiswa);
//                TextView casttnggl =  findViewById(R.id.tepattanggallahir2DetailMahasiswa);
//                TextView casttempat =  findViewById(R.id.email2DetailMahasiswa);
//                TextView castnohp =  findViewById(R.id.noHP2DetailMahasiswa);
//
//
//                castNama.setText(nama);
//                castNim.setText(nim);
//                casttempat.setText(tempatlahir);
//                casttnggl.setText(tanggallahir);
//                castnohp.setText(noHp);
//            }
//
//            @Override
//            public void onFailure(Call<ThesesItem> call, Throwable t) {
//                Log.e("Fail-", t.getLocalizedMessage());
//            }
//        });
    }
}


