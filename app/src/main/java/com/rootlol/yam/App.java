package com.rootlol.yam;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.SystemClock;

import androidx.room.Room;

import com.rootlol.yam.db.MainDB;
import com.rootlol.yam.db.UsersDB;

import java.util.concurrent.TimeUnit;

public class App extends Application {

    //Singleton

    public static App instance;
    private MainDB database;
    private NotificationManager notificationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(instance, MainDB.class, "database").allowMainThreadQueries().build();
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("NotificationPlayer", "the notification of the player",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("the notification of the player");
            channel.enableLights(true);
            channel.setLightColor(Color.BLUE);
            channel.enableVibration(false);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public static App getInstance() {
        return instance;
    }

    public MainDB getDatabase() {
        return database;
    }

    public NotificationManager getNotificationManager(){
        return notificationManager;
    }
}
