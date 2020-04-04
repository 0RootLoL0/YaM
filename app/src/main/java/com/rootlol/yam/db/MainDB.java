package com.rootlol.yam.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {
        UsersDB.UserEntity.class,
        PlaylistCacheDB.PlaylistCacheEntity.class,
        TrackListCacheDB.TrackListCacheEntity.class}, version = 1)
public abstract class MainDB extends RoomDatabase {
    // TODO: создать функцию имеграции
    // TODO: переименовать классы Entity
    public abstract UsersDB.UserDao userDao();
    public abstract PlaylistCacheDB.PlaylistCacheDao playlistCacheDao();
    public abstract TrackListCacheDB.TrackCacheDao trackCacheDao();
}