package com.kelompok_15.tb_ptb;

import androidx.annotation.NonNull;
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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.kelompok_15.tb_ptb.room.AppDatabase;
import com.kelompok_15.tb_ptb.room.User;
import com.kelompok_15.tb_ptb.room.UserDao;

public class EditProfileActivity extends AppCompatActivity {

    private EditText editEmail, editNOHp;
    private Button buttonSimpan, buttonLihat;

    private static final String TAG = "EditProfilActivity";
    private static final String CHANNEL_ID = "ChannelEditProfil";
    Button edit;
    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        Log.d(TAG, token);
                        Toast.makeText(EditProfileActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });

        // ambil notificationManager
        notificationManager = NotificationManagerCompat.from(this);

        // buat channel
        // createNotificationChannel();

        buttonLihat = findViewById(R.id.LihatProfil);
        buttonLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //activity buat button
                //Intent LihatIn = new Intent(EditProfileActivity.this, LihatProfileActivity.class);
                //startActivity(LihatIn);
            }
        });

        String email = editEmail.getText().toString();
        String no_hp = editNOHp.getText().toString();

        editEmail = findViewById(R.id.editEmail);
        editNOHp = findViewById(R.id.editNoHP);

        buttonSimpan = findViewById(R.id.simpanEdit);
        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // activity buat button
                //Intent sidangIn = new Intent(EditProfileActivity.this, LihatProfileActivity.class);
                //startActivity(sidangIn);

                // object db
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                                AppDatabase.class, "database-name")
                        .allowMainThreadQueries()
                        .build();

                // object dao
                UserDao dao = db.userDao();

                User user = new User();
                user.email = email;
                user.no_hp = no_hp;

                dao.insert(user);


                // Create an Intent for the activity you want to start
                Intent resultIntent = new Intent(EditProfileActivity.this, LihatProfileActivity.class);

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
                        .addAction(R.drawable.ic_baseline_notifications_24, "Lihat Profil", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notificationManager.notify(101, builder.build());

            }
        });


    // private void createNotificationChannel() {
       // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
       //     CharSequence name = "Notifikasi";
       //     String description = "Notifikasi Edit Profil";
       //     int importance = NotificationManager.IMPORTANCE_DEFAULT;
       //      NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Edit Profil", NotificationManager.IMPORTANCE_HIGH);
       //     channel.setDescription("Berhasil Edit Profil");
       //     notificationManager.createNotificationChannel(channel);
    //    }
    //}
    }

}