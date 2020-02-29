package com.rootlol.yam.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class PlaylistCacheDB {
    public static final int YANDEX_GEN = 0;
    public static final int USER_CREATE = 1;

    @Entity
    public static class PlaylistCacheEntity {

        @PrimaryKey(autoGenerate = true)
        public int id;

        public String lable;

        public String colTime;

        public String coverImage;

        public int typeP;

        public int kind;

        public String visibility;

        public PlaylistCacheEntity(String lable, String colTime, String coverImage, int typeP, int kind, String visibility) {
            this.lable = lable;
            this.colTime = colTime;
            this.coverImage = coverImage;
            this.typeP = typeP;
            this.kind = kind;
            this.visibility = visibility;
        }
    }
    @Dao
    public interface PlaylistCacheDao {
        @Query("SELECT * FROM playlistcacheentity")
        List<PlaylistCacheEntity> getAll();

        @Query("SELECT * FROM playlistcacheentity WHERE id = :id")
        PlaylistCacheEntity getById(long id);

        @Query("SELECT * FROM (SELECT * FROM PlaylistCacheEntity ORDER BY id DESC LIMIT :size) ORDER BY id ASC LIMIT :limit")
        List<PlaylistCacheEntity> getItemLimit(long size,long limit);

        @Query("DELETE FROM playlistcacheentity")
        void deleteAll();

        @Insert
        void insert(PlaylistCacheEntity playlistCacheEntity);

        @Update
        void update(PlaylistCacheEntity playlistCacheEntity);

        @Delete
        void delete(PlaylistCacheEntity playlistCacheEntity);
    }
}
