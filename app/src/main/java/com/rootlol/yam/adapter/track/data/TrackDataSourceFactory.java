/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.adapter.track.data;

import android.util.Log;

import androidx.paging.DataSource;

import com.rootlol.yam.App;
import com.rootlol.yam.activity.ExceptionActivity;
import com.rootlol.yam.adapter.playlist.PlaylistListInterface;
import com.rootlol.yam.adapter.track.TrackListInterface;
import com.rootlol.yam.adapter.track.item.TrackType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.rootlol.yamapilib.MusicYandexApi;
import io.github.rootlol.yamapilib.pojo.ApiPojoLikesTracks;
import io.github.rootlol.yamapilib.pojo.ApiPojoTracksList;
import io.github.rootlol.yamapilib.pojo.feed.GeneratedPlaylist;
import io.github.rootlol.yamapilib.pojo.feed.Track;
import io.github.rootlol.yamapilib.pojo.TrackAPLT;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackDataSourceFactory extends DataSource.Factory{


    public TrackDataSourceFactory(String feed) {
        List<TrackListInterface> temp = new ArrayList<>();

        GeneratedPlaylist wq = null;
        for (GeneratedPlaylist w:App.getInstance().getApiPojoFeed().getResult().getGeneratedPlaylists()) {
            if (feed.equals(w.getType())) wq = w;
        }

        for (Track q: wq.getData().getTracks()) {
            temp.add(new TrackType(q.getId().toString(), "", q.getTimestamp()));
        }
        TrackDataSourse.getInstance().setData(temp, PlaylistListInterface.FEED);
    }

    public TrackDataSourceFactory(int kind) {
        Map<String, String> TrackPostBody = new HashMap<>();
        TrackPostBody.put("kinds", ""+kind);
        MusicYandexApi.getInstance().getTrackList(App.getInstance().getDatabase().userDao().getAll().get(0).user_id,
                "OAuth "+ App.getInstance().getDatabase().userDao().getAll().get(0).token,
                TrackPostBody).enqueue(new Callback<ApiPojoTracksList>() {
            @Override
            public void onResponse(Call<ApiPojoTracksList> call, Response<ApiPojoTracksList> response) {
                App.getInstance().setApiPojoTracksList(response.body());
                List<TrackListInterface> temp = new ArrayList<>();

                for (TrackAPLT w:response.body().getResultAPTL().get(0).getTrackAPLTs()) {
                    temp.add(new TrackType(w.getId(), w.getAlbumId(), w.getTimestamp()));
                }

                TrackDataSourse.getInstance().setData(temp, PlaylistListInterface.USER_PLAYLIST);
            }

            @Override
            public void onFailure(Call<ApiPojoTracksList> call, Throwable t) {

            }
        });
    }

    public TrackDataSourceFactory() {
        MusicYandexApi.getInstance().getGetLikes(
                App.getInstance().getDatabase().userDao().getAll().get(0).user_id,
                "OAuth "+ App.getInstance().getDatabase().userDao().getAll().get(0).token)
                .enqueue(new Callback<ApiPojoLikesTracks>() {
            @Override
            public void onResponse(Call<ApiPojoLikesTracks> call, Response<ApiPojoLikesTracks> response) {
                App.getInstance().setApiPojoLikesTracks(response.body());
                List<TrackListInterface> temp = new ArrayList<>();

                for (TrackAPLT w:response.body().getResult().getLibrary().getTracks()) {
                    temp.add(new TrackType(w.getId(), w.getAlbumId(), w.getTimestamp()));
                }

                TrackDataSourse.getInstance().setData(temp, PlaylistListInterface.USER_LIKE);
            }

            @Override
            public void onFailure(Call<ApiPojoLikesTracks> call, Throwable t) {
                ExceptionActivity.viewError("getGetLikes");
            }
        });
    }

    @Override
    public DataSource create() {
        return TrackDataSourse.getInstance();
    }
}