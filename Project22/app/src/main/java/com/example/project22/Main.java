package com.example.project22;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;

public class Main extends AppCompatActivity {
    private NotificationManager notificationManager;
    private static final int const1 = 1;
    private static final int const2 = 2;
    private static final int const3 = 3;
    private static final String CHANNEL_ID = "CHANNEL_ID";
    EditText et;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        et = (EditText)findViewById(R.id.et);
    }

    public void btn1(View view){
        ShowNotification(const1, et.getText().toString());
    }
    public void btn2(View view){
        ShowNotification(const2, et.getText().toString());
    }
    public void btn3(View view){
        ShowNotification2(const3, et.getText().toString());
    }

    private void ShowNotification(int id, String text){
        notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(this,Second.class);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        RemoteViews view = new RemoteViews(getPackageName(), R.layout.notification);
        view.setImageViewResource(R.id.image, R.mipmap.ic_launcher);
        view.setTextViewText(R.id.title, getString(R.string.app_name));
        view.setTextViewText(R.id.description, text);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setAutoCancel(false)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.app_name))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setTicker("У вас одно новое сообщение")
                        .setPriority(PRIORITY_HIGH)
                .setContent(view);
        createChannelIfNeeded(notificationManager);
        notificationManager.notify(id, notificationBuilder.build());
    }

    public static void createChannelIfNeeded(NotificationManager manager){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }

    private void ShowNotification2(int id, String text){
        notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(this,Second.class);
        intent.putExtra(getResources().getString(R.string.newintent), text);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        RemoteViews view = new RemoteViews(getPackageName(), R.layout.notification2);
        view.setImageViewResource(R.id.image, R.mipmap.rat);
        view.setTextViewText(R.id.title, getString(R.string.app_name));
        view.setTextViewText(R.id.description, text);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setAutoCancel(false)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(getString(R.string.app_name))
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .setTicker("У вас одно новое сообщение")
                        .setPriority(PRIORITY_HIGH)
                        .setContent(view);
        createChannelIfNeeded(notificationManager);
        notificationManager.notify(id, notificationBuilder.build());
    }
}
