package com.example.project23;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;
import static com.example.project23.MyApp.CHANNEL_ID;

public class Notification {
    private NotificationManager notificationManager;
    Context context;
    public Notification(Context _context){
        context = _context;
    }
    public void ShowNotification(int id, String str, String typeNote){
        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(context.getApplicationContext(), Main.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        PendingIntent pendingIntent = PendingIntent.getActivity(context.getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.notification);
        views.setImageViewResource(R.id.image, R.mipmap.rat);
        views.setTextViewText(R.id.title, typeNote);
        views.setTextViewText(R.id.description, str);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context.getApplicationContext(), CHANNEL_ID)
                        .setAutoCancel(false)
                        .setSmallIcon(R.mipmap.rat)
                        .setContentTitle(typeNote)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .setTicker("Новое сообщение")
                        .setPriority(PRIORITY_HIGH)
                        .setContent(views);
        createChannelIfNeeded(notificationManager);
        notificationManager.notify(id, notificationBuilder.build());
    }

    private static void createChannelIfNeeded(NotificationManager manager){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }
}
