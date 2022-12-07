package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InputNilaiSidangActivity extends AppCompatActivity {

    private static final String CHANNEL_ID ="contoh Kanal";
    private Button buttonShow;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nilai_sidang);

        notificationManager = NotificationManagerCompat.from(this);

        createNotificationChannel();


        buttonShow = findViewById(R.id.MenginputkanNilai);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(InputNilaiSidangActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("TB PTB")
                        .setContentText("Nilai sudah Diinput")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notificationManager.notify(101,builder.build());
            }
        });


    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Contoh Notifikasi";
            String description = "Ini merupakan contoh notifikasi";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);

        }
    }
}