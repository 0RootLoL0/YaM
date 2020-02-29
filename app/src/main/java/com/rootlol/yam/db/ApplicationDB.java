package com.rootlol.yam.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;

public class ApplicationDB {
    public static final int PLAYLIST = 0;
    public static final int TRACK = 1;

    @Entity
    public static class ApplicationEntity {


        @PrimaryKey
        public int id;

        public int isPlaylist;

        public int kindPlailist;

        public int idTrack;

        public int LimitItem;

        public ApplicationEntity(int isPlaylist, int kindPlailist, int idTrack, int LimitItem) {
            this.isPlaylist = isPlaylist;
            this.kindPlailist = kindPlailist;
            this.idTrack = idTrack;
            this.LimitItem = LimitItem;
        }
    }
    @Dao
    public interface ApplicationDao {

        @Query("SELECT * FROM applicationentity WHERE id = 0")
        ApplicationEntity getItem();

        @Insert
        void insert(ApplicationEntity applicationEntity);

        @Update
        void update(ApplicationEntity applicationEntity);

        @Delete
        void delete(ApplicationEntity applicationEntity);
    }
}
