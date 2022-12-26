package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.room.Room;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kelompok_15.tb_ptb.room.AppDatabase;
import com.kelompok_15.tb_ptb.room.User;
import com.kelompok_15.tb_ptb.room.UserDao;

public class EditProfileActivity extends AppCompatActivity {

    private EditText editEmail, editNOHp;
    private Button buttonSimpan;

    private static final String CHANNEL_ID = "test_kanal";
    Button edit;
    NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // ambil notificationManager
        notificationManager = NotificationManagerCompat.from(this);

        // buat channel
        createNotificationChannel();

        editEmail = findViewById(R.id.editEmail);
        editNOHp = findViewById(R.id.editNoHP);

        buttonSimpan = findViewById(R.id.simpanEdit);
        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // activity buat button
                Intent sidangIn = new Intent(EditProfileActivity.this, LihatProfileActivity.class);
                startActivity(sidangIn);

                String email = editEmail.getText().toString();
                String no_hp = editNOHp.getText().toString();

                // Create an Intent for the activity you want to start
                Intent resultIntent = new Intent(EditProfileActivity.this, EditProfileActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(EditProfileActivity.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                // builder untuk buat notifikasi
                NotificationCompat.Builder builder = new NotificationCompat.Builder(EditProfileActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.avatar)
                        .setContentTitle("Profil")
                        .setContentText("Profil Berhasil Diubah")
                        .addAction(R.drawable.ic_baseline_notifications_24, "Edit", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notificationManager.notify(101, builder.build());

                // object db
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "database-name").build();

                // object dao
                UserDao dao = db.userDao();

                User user = new User();
                user.email = email;
                user.no_hp = no_hp;

                dao.insert(user);

            }
        });

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notifikasi";
            String description = "Notifikasi Edit Profil";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Edit Profil", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Berhasil Edit Profil");
            notificationManager.createNotificationChannel(channel);
        }
    }
}