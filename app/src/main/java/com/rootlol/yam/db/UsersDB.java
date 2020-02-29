package com.rootlol.yam.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class UsersDB {

    @Entity
    public static class UserEntity {

        @PrimaryKey
        public int id;

        public String login;

        public String token;

        public int user_id;

        public UserEntity(String login, String token, int user_id) {
            this.login = login;
            this.token = token;
            this.user_id = user_id;
        }
    }
    @Dao
    public interface UserDao {
        @Query("SELECT * FROM userentity")
        List<UserEntity> getAll();

        @Query("SELECT * FROM userentity WHERE id = :id")
        UserEntity getById(long id);

        @Insert
        void insert(UserEntity userEntity);

        @Update
        void update(UserEntity userEntity);

        @Delete
        void delete(UserEntity userEntity);
    }
}
