package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InputNilaiSidangActivity extends AppCompatActivity {

    private static final String CHANNEL_ID ="ChannelDarib";
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

                // Create an Intent for the activity you want to start
                Intent resultIntent = new Intent(InputNilaiSidangActivity.this, InputNilaiSidangActivity.class);
                // Create the TaskStackBuilder and add the intent, which inflates the back stack
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(InputNilaiSidangActivity.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                // Get the PendingIntent containing the entire back stack
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(InputNilaiSidangActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.logounand)
                        .setContentTitle("Dosen TA")
                        .setContentText("Nilai sudah Diinput")
                        .setContentIntent(resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                Notification notification = builder.build();

                notificationManager.notify(101,builder.build());
            }
        });


    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "NotifikasiDarib";
            String description = "Notifikasi Input nilai sidang";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);

        }
    }
}