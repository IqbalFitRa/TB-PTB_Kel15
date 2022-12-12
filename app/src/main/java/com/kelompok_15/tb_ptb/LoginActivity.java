package com.kelompok_15.tb_ptb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.kelompok_15.tb_ptb.retrofit.LoginBody;
import com.kelompok_15.tb_ptb.retrofit.LoginResponse;
import com.kelompok_15.tb_ptb.retrofit.MainInterface;
import com.kelompok_15.tb_ptb.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity-Debug";
    private static final String CHANNEL_ID = "ChannelNotif";
    //Button login;
    //String userName = "Dosen";
    //String password = "dosen";
    private NotificationManagerCompat notifMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                        Toast.makeText(LoginActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });

        notifMan = NotificationManagerCompat.from(this);
        createNotificationChannel();

        Button login =(Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                TextView username = (TextView) findViewById(R.id.emailLogin);
                TextView password = (TextView) findViewById(R.id.passwordLogin);

              /*  MainInterface mainInterface = RetrofitClient.getService();
                Call<LoginResponse> call = mainInterface.postLogin(username.getText().toString(),password.getText().toString());
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {*/
                        if(username.getText().toString().equals("Dosen") && password.getText().toString().equals("dosen")){
                            Intent login = new Intent(LoginActivity.this, MenuActivity.class);
                            startActivity(login);

                            Intent resultIntent = new Intent(LoginActivity.this, LoginActivity.class);

                            TaskStackBuilder stackBuilder = TaskStackBuilder.create(LoginActivity.this);
                            stackBuilder.addNextIntentWithParentStack(resultIntent);
                            PendingIntent resultPendingIntent =
                                    stackBuilder.getPendingIntent(0,
                                            PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                            NotificationCompat.Builder builder = new NotificationCompat.Builder(LoginActivity.this, CHANNEL_ID)
                                    .setSmallIcon(R.drawable.logounand)
                                    .setContentTitle("Notifikasi Login")
                                    .setContentText("Login berhasil")
                                    .setContentIntent(resultPendingIntent)
                                    .addAction(R.drawable.logounand,"Lihat",resultPendingIntent)
                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                            notifMan.notify(101, builder.build());

                        }else
                            Toast.makeText(LoginActivity.this, "Email/Password Wrong", Toast.LENGTH_SHORT).show();

                    }

                   /* @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                    }
                });

            }*/
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