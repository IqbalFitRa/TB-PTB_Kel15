package com.kelompok_15.tb_ptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "ChannelNotif";
    //Button login;
    //String userName = "Dosen";
    //String password = "dosen";
    private NotificationManagerCompat notifMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        notifMan = NotificationManagerCompat.from(this);

        Button login =(Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                TextView username = (TextView) findViewById(R.id.emailLogin);
                TextView password = (TextView) findViewById(R.id.passwordLogin);

                if(username.getText().toString().equals("Dosen") && password.getText().toString().equals("dosen")){
                    Intent login = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(login);
                }else
                    Toast.makeText(LoginActivity.this, "Email/Password Wrong", Toast.LENGTH_SHORT).show();
            }
        });

        Button notiffr =(Button) findViewById(R.id.notif_Fr);
        notiffr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(LoginActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.logounand)
                        .setContentTitle("Notifikasi Login")
                        .setContentText("Login berhasil")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notifMan.notify(101, builder.build());
            }
        });

    }

    //channel
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Login Notifikasi", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("This is Description for Login Notification");
            notifMan.createNotificationChannel(channel);
        }
    }
}