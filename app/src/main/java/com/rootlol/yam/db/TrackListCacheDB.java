package com.rootlol.yam.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class TrackListCacheDB {

    @Entity
    public static class TrackListCacheEntity {

        @PrimaryKey(autoGenerate = true)
        public int id;

        public String titleTrack;

        public String track_id;

        public String versionTrack;

        public int artists_id;

        public String artists_name;

        public int albums_id;

        public String albums_title;

        public String coverImage;

        public int durationMs;

        public int playlistKind;

        public TrackListCacheEntity(String titleTrack, String track_id, String versionTrack, int artists_id, String artists_name, int albums_id, String albums_title, String coverImage, int durationMs, int playlistKind) {
            this.titleTrack = titleTrack;
            this.track_id = track_id;
            this.versionTrack = versionTrack;
            this.artists_id = artists_id;
            this.artists_name = artists_name;
            this.albums_id = albums_id;
            this.albums_title = albums_title;
            this.coverImage = coverImage;
            this.durationMs = durationMs;
            this.playlistKind = playlistKind;
        }
    }
    @Dao
    public interface TrackCacheDao {
        @Query("SELECT * FROM TrackListCacheEntity")
        List<TrackListCacheEntity> getAll();

        @Query("SELECT * FROM TrackListCacheEntity WHERE playlistKind LIKE :playlistKind")
        List<TrackListCacheEntity> getAlltag(int playlistKind);

        @Query("SELECT * FROM TrackListCacheEntity WHERE id = :id")
        TrackListCacheEntity getById(long id);

        @Query("SELECT * FROM (SELECT * FROM (SELECT * FROM TrackListCacheEntity WHERE playlistKind LIKE :playlistKind) ORDER BY id DESC LIMIT :size) ORDER BY id ASC LIMIT :limit")
        List<TrackListCacheEntity> getItemLimit(int playlistKind, long size, long limit);

        @Query("DELETE FROM TrackListCacheEntity WHERE playlistKind = :kind")
        void deleteAlltag(int kind);

        @Insert
        void insert(TrackListCacheEntity playlistCacheEntity);

        @Update
        void update(TrackListCacheEntity playlistCacheEntity);

        @Delete
        void delete(TrackListCacheEntity playlistCacheEntity);
    }

}
