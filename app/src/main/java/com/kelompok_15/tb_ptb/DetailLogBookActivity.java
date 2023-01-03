package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.kelompok_15.tb_ptb.retrofit.LogbooksItem;

public class DetailLogBookActivity extends AppCompatActivity {

    TextView tanggalDetailLogbook, progressDetailLogbook, problemDetailLogbook;
    //int judulTADetailLogbook,pembimbingDetailLogbook,statusDetailLogbook;
    LogbooksItem logbooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_log_book);

        // judulTADetailLogbook = findViewById(R.id.judulTADetailLogbook);
        //abstrakDetailLogbook = findViewById(R.id.abstrakDetailLogbook);
        // pembimbingDetailLogbook = findViewById(R.id.pembimbingDetailLogbook);
        tanggalDetailLogbook = findViewById(R.id.tanggalDetailLogbook);
        progressDetailLogbook = findViewById(R.id.progressDetailLogbook);
        problemDetailLogbook = findViewById(R.id.problemDetailLogbook);
        //statusDetailLogbook = findViewById(R.id.statusDetailLogbook);

        Intent listlogbook = getIntent();
        if (listlogbook.getExtras() != null) {
            logbooks = (LogbooksItem) listlogbook.getSerializableExtra("data");
            String tanggalDetailLogbookData = logbooks.getDate();
            String progressDetailLogbookData = logbooks.getProgress();
            String problemDetailLogbookData = logbooks.getProblem();

            tanggalDetailLogbook.setText(tanggalDetailLogbookData);
            progressDetailLogbook.setText(progressDetailLogbookData);
            problemDetailLogbook.setText(problemDetailLogbookData);
        }
    }
}