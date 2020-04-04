package com.rootlol.yam;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.rootlol.yam.db.MainDB;
import com.rootlol.yam.db.UsersDB;
import com.rootlol.yam.nadapter.playlist.PlaylistAdapter;

import java.util.concurrent.TimeUnit;

public class App extends Application {

    //Singleton

    public static App instance;
    private MainDB database;
    private int kind;
    private AppCompatActivity appCompatActivity;
    private PlaylistAdapter playlistAdapter;

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
    public int getKind() {
        return kind;
    }
    public void setKind(int kind) {
        this.kind = kind;
    }
    public AppCompatActivity getAppCompatActivity() {
        return appCompatActivity;
    }
    public void setAppCompatActivity(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }
    public PlaylistAdapter getPlaylistAdapter() {
        return playlistAdapter;
    }
    public void setPlaylistAdapter(PlaylistAdapter playlistAdapter) {
        this.playlistAdapter = playlistAdapter;
    }
}
