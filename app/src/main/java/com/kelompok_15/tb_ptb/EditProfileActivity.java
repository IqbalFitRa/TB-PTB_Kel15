package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditProfileActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "test_kanal";
    Button edit;
    NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        notificationManager = NotificationManagerCompat.from(this);

        createNotificationChannel();

        edit = findViewById(R.id.simpanEdit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sidangIn = new Intent(EditProfileActivity.this, LihatProfileActivity.class);
                startActivity(sidangIn);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(EditProfileActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.profil)
                        .setContentTitle("Profile")
                        .setContentText("Profil Berhasil Diubah")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notificationManager.notify(101, builder.build());
            }
        });

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notifikasi";
            String description = "Notifikasi Edit Profil";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }
    }
}