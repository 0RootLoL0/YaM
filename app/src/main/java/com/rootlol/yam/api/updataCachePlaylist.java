package com.rootlol.yam.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.rootlol.yam.db.PlaylistCacheDB;
import com.rootlol.yam.db.UsersDB;
import com.rootlol.yam.pojo.feed.FeedPojo;
import com.rootlol.yam.pojo.feed.GeneratedPlaylist;
import com.rootlol.yam.pojo.playlistslist.PlaylistListPojo;
import com.rootlol.yam.pojo.playlistslist.Result;
import com.rootlol.yam.tools.ImageTool;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public abstract class updataCachePlaylist extends AsyncTask<UsersDB.UserEntity, Void, List<PlaylistCacheDB.PlaylistCacheEntity>> {

    public List<GeneratedPlaylist> getFeed(String token){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.music.yandex.net/feed")
                .header("Authorization", "OAuth "+token)
                .build();

        try {
            okhttp3.Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            FeedPojo FP = gson.fromJson(response.body().string(), FeedPojo.class);

            if (FP != null){
                return FP.getResult().getGeneratedPlaylists();
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public String getBase64Image(String src){
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return ImageTool.convert(myBitmap);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Result> getPLaylistList(int id, String token){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.music.yandex.net/users/"+id+"/playlists/list")
                .header("Authorization", "OAuth "+token)
                .build();

        try {
            okhttp3.Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            PlaylistListPojo PLLP = gson.fromJson(response.body().string(), PlaylistListPojo.class);

            if (PLLP != null){
                return PLLP.getResult();
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }


    @Override
    protected List<PlaylistCacheDB.PlaylistCacheEntity> doInBackground(UsersDB.UserEntity... lp) {
        List<PlaylistCacheDB.PlaylistCacheEntity> tempItem = new ArrayList<>();

        List<GeneratedPlaylist> mGetFeed = getFeed(lp[0].token);
        if (mGetFeed != null){
            for (GeneratedPlaylist generatedPlaylist : mGetFeed){
                tempItem.add( new PlaylistCacheDB.PlaylistCacheEntity(
                        generatedPlaylist.getData().getTitle(),
                        generatedPlaylist.getData().getModified(),
                        getBase64Image("https://" + generatedPlaylist.getData().getCover().getUri().replace("%%", "100x100")),
                        PlaylistCacheDB.YANDEX_GEN,
                        0,
                        generatedPlaylist.getData().getVisibility()
                ));
            }
        }

        tempItem.add(new PlaylistCacheDB.PlaylistCacheEntity("Мне нравится", " ", getBase64Image("https://music.yandex.ru/blocks/playlist-cover/playlist-cover_like.png"), PlaylistCacheDB.USER_CREATE,3,"visibli"));

        List<Result> mGetPlaylistList = getPLaylistList(lp[0].user_id, lp[0].token);
        if (mGetPlaylistList != null){
            for (Result generatedPlaylist : mGetPlaylistList){
                tempItem.add( new PlaylistCacheDB.PlaylistCacheEntity(
                        generatedPlaylist.getTitle(),
                        generatedPlaylist.getModified(),
                        getBase64Image("https://" + generatedPlaylist.getOgImage().replace("%%", "100x100")),
                        PlaylistCacheDB.USER_CREATE,
                        generatedPlaylist.getKind().intValue(),
                        generatedPlaylist.getVisibility()
                ));
            }
        }

        return tempItem;
    }
}