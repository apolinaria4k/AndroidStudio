package com.example.project33;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;
import static com.example.project33.MyApp.CHANNEL_ID;

public class Notification {
    private NotificationManager notificationManager;
    Context context;

    public Notification(Context _context) {
        context = _context;
    }

    public void showNotification(int id, String text, String typeNote) {
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(context.getApplicationContext(), Main.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);  //класс активности, которая открывается при просмотре сообщения об уведомлении.  У Вас на этой активности может находиться, например, один TextView c текстом «Просмотр сообщения».
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        PendingIntent pendingIntent = PendingIntent.getActivity(context.getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        RemoteViews view = new RemoteViews(context.getPackageName(), R.layout.notification);  //разметка для сообщения об уведомлении
        view.setImageViewResource(R.id.image, R.mipmap.cat2);
        view.setTextViewText(R.id.title, typeNote);
        view.setTextViewText(R.id.description, text);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context.getApplicationContext(), CHANNEL_ID)
                        .setAutoCancel(false)
                        .setSmallIcon(R.mipmap.cat2)
                        .setContentTitle(typeNote)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .setTicker("Новое сообщение")
                        .setPriority(PRIORITY_HIGH)
                        .setContent(view);
        createChannelIfNeeded(notificationManager);
        notificationManager.notify(id, notificationBuilder.build());
    }

    private static void createChannelIfNeeded(NotificationManager manager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }
}
