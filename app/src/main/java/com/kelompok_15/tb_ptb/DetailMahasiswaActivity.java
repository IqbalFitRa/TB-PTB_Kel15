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
import com.kelompok_15.tb_ptb.retrofit.detailtamahasiswa.DetailTAResponse;
import com.kelompok_15.tb_ptb.retrofit.detailtamahasiswa.SupervisorsItem;
import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.ListMahasiswaResponse;
import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.Student;
import com.kelompok_15.tb_ptb.retrofit.listmahasiswa.ThesesItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMahasiswaActivity extends AppCompatActivity {

    Button button;
    String namaMahasiswa, nimMahasiswa;
    TextView namaDetailMahasiswa, nimDetailMahasiswa;
    String gettoken, token;
    public ImageView imageProfil2;
    public TextView nama2, nim2, tempatlhr, tanggallhr, nohp;
    Student student;
    ThesesItem thesesItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        getDetailMahasiswa();


        button = findViewById(R.id.DetailTADetailMahasiswa);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                getDetailTA();

                Intent intent = new Intent(DetailMahasiswaActivity.this, DetailTaMahasiswa.class);
                startActivity(intent);
            }
        });

        //jan dihapus
//        Intent detailIntent = getIntent();
//        if (detailIntent != null) {
//
////            thesesItem = (ThesesItem) detailIntent.getSerializableExtra("data");
//
////            student = (Student) detailIntent.getSerializableExtra("data");
////
//
//
//            String namaMahasiswa = detailIntent.getStringExtra("NAMA_MAHASISWA");
//            TextView textNamaMahasiswa = findViewById(R.id.namaDetailMahasiswa);
//            textNamaMahasiswa.setText(namaMahasiswa);
//        }
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
    public void getDetailMahasiswa() {

        MainInterface mainInterface = RetrofitClient.getService();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY", MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;
        Toast.makeText(DetailMahasiswaActivity.this, token, Toast.LENGTH_SHORT).show();

        Call<ThesesItem> call = mainInterface.theseitems(token);
        call.enqueue(new Callback<ThesesItem>() {
            @Override
            public void onResponse(Call<ThesesItem> call, Response<ThesesItem> response) {

                Log.e("Succ-", response.toString());
                ThesesItem thesesItem = response.body();

                String nama = thesesItem.getStudent().getName();
                String nim = thesesItem.getStudent().getNim();
                String tanggallahir = thesesItem.getStudent().getBirthplace();
                String tempatlahir = thesesItem.getStudent().getBirthday();
                String noHp = thesesItem.getStudent().getPhone();

                TextView castNama = findViewById(R.id.namaDetailMahasiswa);
                TextView castNim =  findViewById(R.id.nimDetailMahasiswa);
                TextView casttnggl =  findViewById(R.id.tepattanggallahir2DetailMahasiswa);
                TextView casttempat =  findViewById(R.id.email2DetailMahasiswa);
                TextView castnohp =  findViewById(R.id.noHP2DetailMahasiswa);


                castNama.setText(nama);
                castNim.setText(nim);
                casttempat.setText(tempatlahir);
                casttnggl.setText(tanggallahir);
                castnohp.setText(noHp);
            }

            @Override
            public void onFailure(Call<ThesesItem> call, Throwable t) {
                Log.e("Fail-", t.getLocalizedMessage());
            }
        });

    }
}
