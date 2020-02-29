package com.rootlol.yam;

import android.app.Application;
import android.content.Context;
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

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(instance, MainDB.class, "database").allowMainThreadQueries().build();
    }

    public static App getInstance() {
        return instance;
    }

    public MainDB getDatabase() {
        return database;
    }

}
