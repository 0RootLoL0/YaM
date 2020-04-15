/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.rootlol.yam.db.MainDB;
import io.github.rootlol.yamapilib.pojo.feed.ApiPojoFeed;
import io.github.rootlol.yamapilib.pojo.ApiPojoLikesTracks;
import io.github.rootlol.yamapilib.pojo.ApiPojoPlaylistList;
import io.github.rootlol.yamapilib.pojo.ApiPojoTracksList;

public class App extends Application {

    public static App instance;
    private MainDB database;
    private AppCompatActivity appCompatActivity;

    public final static int defultItemView = 20;

    private ApiPojoFeed apiPojoFeed;
    public ApiPojoFeed getApiPojoFeed() {
        return apiPojoFeed;
    }
    public void setApiPojoFeed(ApiPojoFeed apiPojoFeed) {
        this.apiPojoFeed = apiPojoFeed;
    }

    private ApiPojoPlaylistList apiPojoPlaylistList;
    public ApiPojoPlaylistList getApiPojoPlaylistList() {
        return apiPojoPlaylistList;
    }
    public void setApiPojoPlaylistList(ApiPojoPlaylistList apiPojoPlaylistList) {
        this.apiPojoPlaylistList = apiPojoPlaylistList;
    }

    private ApiPojoLikesTracks apiPojoLikesTracks;
    public ApiPojoLikesTracks getApiPojoLikesTracks() {
        return apiPojoLikesTracks;
    }
    public void setApiPojoLikesTracks(ApiPojoLikesTracks apiPojoLikesTracks) {
        this.apiPojoLikesTracks = apiPojoLikesTracks;
    }

    private ApiPojoTracksList apiPojoTracksList;
    public ApiPojoTracksList getApiPojoTracksList() {
        return apiPojoTracksList;
    }
    public void setApiPojoTracksList(ApiPojoTracksList apiPojoTracksList) {
        this.apiPojoTracksList = apiPojoTracksList;
    }

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
