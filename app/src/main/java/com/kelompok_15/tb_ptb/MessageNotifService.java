package com.kelompok_15.tb_ptb;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessageNotifService extends FirebaseMessagingService {

    private static final String CHANNEL_ID = "ChannelNotif";
    private static final String TAG = "Service-debug";
    private NotificationManagerCompat notifMan;

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "Refreshed token: " + token);

    }


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
       //notifMan = NotificationManagerCompat.from(this);
        displayNotification(remoteMessage.getNotification());
    }

    private void displayNotification(RemoteMessage.Notification notification) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Login Notifikasi", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("This is Description for Login Notification");
            NotificationManagerCompat.from(this).createNotificationChannel(channel);
        }

        Intent resultIntent = new Intent(this, ListPermintaanBimbinganActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logounand)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setContentIntent(resultPendingIntent)
                .addAction(R.drawable.logounand,"Lihat",resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat.from(this).notify(101, builder.build());
    }

}