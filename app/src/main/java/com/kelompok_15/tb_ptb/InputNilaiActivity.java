package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class InputNilaiActivity extends AppCompatActivity {
    String[] items = {"A","B","C","D"};

    AutoCompleteTextView autoCompleteTxt;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nilai);

        autoCompleteTxt = findViewById(R.id.kinerjaMhsAutoComtxt);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_nilai,items);

        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener (new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Item : " + item, Toast.LENGTH_SHORT).show();
            }
                                           }
        );
    }
}