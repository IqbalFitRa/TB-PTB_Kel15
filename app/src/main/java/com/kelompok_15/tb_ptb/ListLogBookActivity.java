package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.kelompok_15.tb_ptb.adapters.AdapterLogbook;
import com.kelompok_15.tb_ptb.models.Logbook;
import com.kelompok_15.tb_ptb.retrofit.ListLogbook;
import com.kelompok_15.tb_ptb.retrofit.LogbooksItem;
import com.kelompok_15.tb_ptb.retrofit.LoginResponse;
import com.kelompok_15.tb_ptb.retrofit.MainInterface;
import com.kelompok_15.tb_ptb.retrofit.RetrofitClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListLogBookActivity extends AppCompatActivity implements AdapterLogbook.ClickedItem{

    private RecyclerView rvLogbook;
    private AdapterLogbook adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_log_book);

        SharedPreferences sharedPreferences = getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY",MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");

        rvLogbook = findViewById(R.id.list_logbook);
        rvLogbook.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AdapterLogbook(this::ClickedLogbook);
        rvLogbook.setAdapter(adapter);



        //minta data ke serper

        MainInterface mainInterface = RetrofitClient.getService();
        Call<ListLogbook> call = mainInterface.listlogbook(309,"Bearer " + token);
        call.enqueue(new Callback<ListLogbook>() {
            @Override
            public void onResponse(Call<ListLogbook> call, Response<ListLogbook> response) {

                ListLogbook listLogbook = response.body();
                if(listLogbook != null){
                    List<LogbooksItem> logbooks = listLogbook.getLogbooks();
                    adapter.setItemList(logbooks);
                    //tambahan
                    rvLogbook.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListLogbook> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });

    }

    @Override
    public void ClickedLogbook(LogbooksItem logbooks) {
        startActivity(new Intent (this,DetailLogBookActivity.class).putExtra("data", (Serializable) logbooks));
    }

}